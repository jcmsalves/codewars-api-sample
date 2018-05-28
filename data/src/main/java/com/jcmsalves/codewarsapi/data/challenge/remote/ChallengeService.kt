package com.jcmsalves.codewarsapi.data.challenge.remote

import com.jcmsalves.codewarsapi.data.challenge.remote.model.AuthoredChallenge
import com.jcmsalves.codewarsapi.data.challenge.remote.model.CompletedChallenge
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ChallengeService {

    @GET("users/{username}/code-challenges/authored")
    fun getUserAuthoredChallenges(@Path("username") username: String): Single<AuthoredChallenge>

    @GET("users/{username}/code-challenges/completed")
    fun getUserCompletedChallenges(@Path("username") username: String): Single<CompletedChallenge>
}
