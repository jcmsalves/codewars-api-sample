package com.jcmsalves.codewarsapi.data.challenge

import com.jcmsalves.codewarsapi.data.challenge.local.dao.ChallengeDao
import com.jcmsalves.codewarsapi.data.challenge.mappers.AuthoredChallengeModelToAuthoredChallengeDbMapper
import com.jcmsalves.codewarsapi.data.challenge.mappers.CompletedChallengeModelToCompletedChallengeDbMapper
import com.jcmsalves.codewarsapi.data.challenge.remote.ChallengeService
import com.jcmsalves.codewarsapi.data.challenge.remote.model.AuthoredChallengeModel
import com.jcmsalves.codewarsapi.data.challenge.remote.model.CompletedChallengeModel
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import com.jcmsalves.codewarsapi.domain.challenge.ChallengeRepository
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import io.reactivex.Single
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
    private val challengeService: ChallengeService,
    private val challengeDao: ChallengeDao,
    private val completedChallengeDbMapper: CompletedChallengeModelToCompletedChallengeDbMapper,
    private val authoredChallengeDbMapper: AuthoredChallengeModelToAuthoredChallengeDbMapper
) : ChallengeRepository {

    override fun getAuthoredChallenges(username: String, refresh: Boolean): Single<List<AuthoredChallenge>> {
        return when (refresh) {
            true -> fetchAuthoredChallengesFromRemote(username)
            false -> fetchAuthoredChallengesFromDb(username)
        }
    }

    private fun fetchAuthoredChallengesFromDb(username: String): Single<List<AuthoredChallenge>> {
        return challengeDao.getAuthoredChallenges(username)
            .onErrorResumeNext { fetchAuthoredChallengesFromRemote(username) }
    }

    private fun fetchAuthoredChallengesFromRemote(username: String): Single<List<AuthoredChallenge>> {
        return challengeService.getUserAuthoredChallenges(username)
            .map { storeAuthoredChallenges(it.challengeModels, username) }
            .flatMap { fetchAuthoredChallengesFromDb(username) }
    }

    private fun storeAuthoredChallenges(authoredChallenges: List<AuthoredChallengeModel>, username: String) {
        authoredChallenges.forEach {
            challengeDao.insertAuthoredChallenge(authoredChallengeDbMapper.map(it, username))
        }
    }

    override fun getCompletedChallenges(username: String, refresh: Boolean): Single<List<CompletedChallenge>> {
        return when (refresh) {
            true -> fetchCompletedChallengesFromRemote(username)
            false -> fetchCompletedChallengesFromDb(username)
        }
    }

    private fun fetchCompletedChallengesFromDb(username: String): Single<List<CompletedChallenge>> {
        return challengeDao.getCompletedChallenges(username)
            .onErrorResumeNext { fetchCompletedChallengesFromRemote(username) }
    }

    private fun fetchCompletedChallengesFromRemote(username: String): Single<List<CompletedChallenge>> {
        return challengeService.getUserCompletedChallenges(username)
            .map { storeCompletedChallenges(it.challengeModels, username) }
            .flatMap { fetchCompletedChallengesFromDb(username) }
    }

    private fun storeCompletedChallenges(authoredChallenges: List<CompletedChallengeModel>, username: String) {
        authoredChallenges.forEach {
            challengeDao.insertCompletedChallenge(completedChallengeDbMapper.map(it, username))
        }
    }
}
