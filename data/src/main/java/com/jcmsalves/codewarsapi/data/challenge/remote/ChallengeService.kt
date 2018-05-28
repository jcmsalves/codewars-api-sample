package com.jcmsalves.codewarsapi.data.challenge.remote

import com.jcmsalves.codewarsapi.data.challenge.remote.model.AuthoredChallengesWrapperModel
import com.jcmsalves.codewarsapi.data.challenge.remote.model.CompletededChallengesWrapperModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ChallengeService {

    @GET("users/{username}/code-challenges/authored")
    fun getUserAuthoredChallenges(@Path("username") username: String): Single<AuthoredChallengesWrapperModel>

    @GET("users/{username}/code-challenges/completed")
    fun getUserCompletedChallenges(@Path("username") username: String): Single<CompletededChallengesWrapperModel>
}
