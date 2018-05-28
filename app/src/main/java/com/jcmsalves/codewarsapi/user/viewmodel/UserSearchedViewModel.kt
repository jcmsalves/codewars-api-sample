package com.jcmsalves.codewarsapi.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.getuser.GetUserInteractor
import com.jcmsalves.codewarsapi.domain.user.getuser.GetUserRequest
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UserSearchedViewModel @Inject constructor(private val getUserInteractor: GetUserInteractor) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var searchedUser: MutableLiveData<SearchedUserState> = MutableLiveData()

    fun searchUser(username: String) = compositeDisposable.add(
        getUserInteractor.execute(GetUserRequest(username, true))
            .doOnSubscribe { searchedUser.postValue(SearchedUserState.Loading()) }
            .subscribe(
                { user: User? ->
                    if (user == null) {
                        searchedUser.postValue(SearchedUserState.Error())
                    } else {
                        searchedUser.postValue(SearchedUserState.Data(user))
                    }
                },
                { _: Throwable? -> searchedUser.postValue(SearchedUserState.Error()) }))

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
