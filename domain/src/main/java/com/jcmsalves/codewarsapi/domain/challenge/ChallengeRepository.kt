package com.jcmsalves.codewarsapi.domain.challenge

import io.reactivex.Single

interface ChallengeRepository {

    fun getAuthoredChallenges(username: String, refresh: Boolean): Single<List<AuthoredChallenge>>

    fun getCompletedChallenges(username: String, refresh: Boolean): Single<List<CompletedChallenge>>
}
