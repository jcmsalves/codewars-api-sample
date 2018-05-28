package com.jcmsalves.codewarsapi.domain.challenge.getCompletedChallenges

import com.jcmsalves.codewarsapi.domain.Interactor
import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import com.jcmsalves.codewarsapi.domain.challenge.ChallengeRepository
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import io.reactivex.Observable
import javax.inject.Inject

class GetCompletedChallengesInteractor @Inject constructor(
    private val challengeRepository: ChallengeRepository,
    private val rxJava2Schedulers: RxJava2Schedulers
) : Interactor<GetCompletedChallengesRequest, List<CompletedChallenge>> {

    override fun execute(request: GetCompletedChallengesRequest): Observable<List<CompletedChallenge>> {
        return challengeRepository.getCompletedChallenges(request.username, request.refresh)
            .subscribeOn(rxJava2Schedulers.io())
            .observeOn(rxJava2Schedulers.main())
            .toObservable()
    }
}
