package com.jcmsalves.codewarsapi.challenge.completed.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import com.jcmsalves.codewarsapi.domain.challenge.getCompletedChallenges.GetCompletedChallengesInteractor
import com.jcmsalves.codewarsapi.domain.challenge.getCompletedChallenges.GetCompletedChallengesRequest
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CompletedChallengesViewModel @Inject constructor(private val getCompletedChallengesInteractor
                                                       : GetCompletedChallengesInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var completedChallenges: MutableLiveData<CompletedChallengesState> = MutableLiveData()

    fun getCompletedChallenges(username: String, refresh: Boolean) = compositeDisposable.add(
        getCompletedChallengesInteractor.execute(GetCompletedChallengesRequest(username, refresh))
            .doOnSubscribe { completedChallenges.postValue(CompletedChallengesState.Loading()) }
            .subscribe(
                { challenges: List<CompletedChallenge> -> completedChallenges.postValue(CompletedChallengesState.Data(challenges)) },
                { _: Throwable? -> completedChallenges.postValue(CompletedChallengesState.Error()) })
    )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
