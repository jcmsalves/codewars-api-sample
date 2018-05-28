package com.jcmsalves.codewarsapi.domain.challenge.getauthoredchallenges

import com.jcmsalves.codewarsapi.domain.Interactor
import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import com.jcmsalves.codewarsapi.domain.challenge.ChallengeRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAuthoredChallengesInteractor @Inject constructor(
    private val challengeRepository: ChallengeRepository,
    private val rxJava2Schedulers: RxJava2Schedulers
) : Interactor<GetAuthoredChallengesRequest, List<AuthoredChallenge>> {

    override fun execute(request: GetAuthoredChallengesRequest): Observable<List<AuthoredChallenge>> {
        return challengeRepository.getAuthoredChallenges(request.username, request.refresh)
            .subscribeOn(rxJava2Schedulers.io())
            .observeOn(rxJava2Schedulers.main())
            .toObservable()
    }
}
