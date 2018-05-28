package com.jcmsalves.codewarsapi.domain.user.getRecentSearchedUsers

import com.jcmsalves.codewarsapi.domain.Interactor
import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetRecentSearchedUsersInteractor @Inject constructor(
    private val userRepository: UserRepository,
    private val rxJava2Schedulers: RxJava2Schedulers
) : Interactor<GetRecentSearchedUsersRequest, List<User>> {

    override fun execute(request: GetRecentSearchedUsersRequest): Observable<List<User>> {
        return userRepository.getRecentSearchedUsers(request.sortByLeaderboard)
            .subscribeOn(rxJava2Schedulers.io())
            .observeOn(rxJava2Schedulers.main())
            .toObservable()
    }
}
