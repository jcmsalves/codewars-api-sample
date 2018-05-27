package com.jcmsalves.codewarsapi.domain.user

import io.reactivex.Single

interface UserRepository {

    fun getUser(userSearch: String, refresh: Boolean): Single<User>
}
