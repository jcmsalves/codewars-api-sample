package com.jcmsalves.codewarsapi.domain.challenge

import io.reactivex.Single

interface ChallengeRepository {

    fun getAuthoredChallenges(username: String): Single<List<AuthoredChallenge>>

    fun getCompletedChallenges(username: String): Single<List<CompletedChallenge>>
}
