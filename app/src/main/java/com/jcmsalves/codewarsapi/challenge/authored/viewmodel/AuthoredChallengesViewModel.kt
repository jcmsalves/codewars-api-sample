package com.jcmsalves.codewarsapi.challenge.authored.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import com.jcmsalves.codewarsapi.domain.challenge.getauthoredchallenges.GetAuthoredChallengesInteractor
import com.jcmsalves.codewarsapi.domain.challenge.getauthoredchallenges.GetAuthoredChallengesRequest
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AuthoredChallengesViewModel @Inject constructor(private val getAuthoredChallengesInteractor
                                                      : GetAuthoredChallengesInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var authoredChallenges: MutableLiveData<AuthoredChallengesState> = MutableLiveData()

    fun getAuthoredChallenges(username: String, refresh: Boolean) = compositeDisposable.add(
        getAuthoredChallengesInteractor.execute(GetAuthoredChallengesRequest(username, refresh))
            .doOnSubscribe { authoredChallenges.postValue(AuthoredChallengesState.Loading()) }
            .subscribe(
                { challenges: List<AuthoredChallenge> -> authoredChallenges.postValue(AuthoredChallengesState.Data(challenges)) },
                { _: Throwable? -> authoredChallenges.postValue(AuthoredChallengesState.Error()) })
    )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
