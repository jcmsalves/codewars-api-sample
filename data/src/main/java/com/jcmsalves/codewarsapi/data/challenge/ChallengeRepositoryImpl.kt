package com.jcmsalves.codewarsapi.data.challenge

import com.jcmsalves.codewarsapi.data.challenge.remote.ChallengeService
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import com.jcmsalves.codewarsapi.domain.challenge.ChallengeRepository
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import io.reactivex.Single
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
    private val challengeService: ChallengeService
) : ChallengeRepository {

    override fun getAuthoredChallenges(username: String): Single<List<AuthoredChallenge>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompletedChallenges(username: String): Single<List<CompletedChallenge>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
