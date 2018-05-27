package com.jcmsalves.codewarsapi.domain.user.getuser

import com.jcmsalves.codewarsapi.domain.Interactor
import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.UserRepository

import io.reactivex.Observable
import javax.inject.Inject

class GetUserInteractor @Inject constructor(
    private val userRepository: UserRepository,
    private val rxJava2Schedulers: RxJava2Schedulers
) : Interactor<GetUserRequest, User?> {

    override fun execute(request: GetUserRequest): Observable<User?> {
        return userRepository.getUser(request.userSearch, request.refresh)
            .subscribeOn(rxJava2Schedulers.io())
            .observeOn(rxJava2Schedulers.main())
            .toObservable()
    }

}
