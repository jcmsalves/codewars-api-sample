package com.jcmsalves.codewarsapi.data.user.remote

import com.jcmsalves.codewarsapi.data.user.remote.model.UserModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/v1/users/{id_or_username}")
    fun getUser(@Path("id_or_username") userSearch: String): Single<UserModel>
}
