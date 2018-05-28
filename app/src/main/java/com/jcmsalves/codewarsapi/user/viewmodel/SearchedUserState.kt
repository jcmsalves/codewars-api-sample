package com.jcmsalves.codewarsapi.user.viewmodel

import com.jcmsalves.codewarsapi.domain.user.User

sealed class SearchedUserState {
    class Error : SearchedUserState()
    class Loading : SearchedUserState()
    data class Data(val user: User) : SearchedUserState()
}
