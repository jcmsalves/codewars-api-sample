package com.jcmsalves.codewarsapi.user.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jcmsalves.codewarsapi.domain.user.getuser.GetUserInteractor
import javax.inject.Inject

class RecentSearchesViewModel @Inject constructor(private val getUserInteractor: GetUserInteractor) : ViewModel() {

    var searchedUser: MutableLiveData<RecentSearchesState> = MutableLiveData()

    // fun getRecentSearches() = create interactor to get recent searches
}
