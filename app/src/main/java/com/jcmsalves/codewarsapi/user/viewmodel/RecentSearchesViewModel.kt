package com.jcmsalves.codewarsapi.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.getRecentSearchedUsers.GetRecentSearchedUsersInteractor
import com.jcmsalves.codewarsapi.domain.user.getRecentSearchedUsers.GetRecentSearchedUsersRequest
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RecentSearchesViewModel @Inject constructor(private val getRecentSearchedUsersInteractor: GetRecentSearchedUsersInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var recentSearches: MutableLiveData<RecentSearchesState> = MutableLiveData()

    fun getRecentSearches(sortByLeaderboard: Boolean) = compositeDisposable.add(
        getRecentSearchedUsersInteractor.execute(GetRecentSearchedUsersRequest(sortByLeaderboard))
            .doOnSubscribe { recentSearches.postValue(RecentSearchesState.Loading()) }
            .subscribe(
                { usersList: List<User> -> recentSearches.postValue(RecentSearchesState.Data(usersList)) },
                { _: Throwable? -> recentSearches.postValue(RecentSearchesState.Error())}))

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
