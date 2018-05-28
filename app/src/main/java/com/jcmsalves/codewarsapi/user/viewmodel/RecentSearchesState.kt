package com.jcmsalves.codewarsapi.user.viewmodel

import com.jcmsalves.codewarsapi.domain.user.User

sealed class RecentSearchesState {
    class Error : RecentSearchesState()
    class Loading : RecentSearchesState()
    data class Data(val users: List<User>) : RecentSearchesState()
}
