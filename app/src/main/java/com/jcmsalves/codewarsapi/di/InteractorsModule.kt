package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import com.jcmsalves.codewarsapi.domain.user.getuser.GetUserInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorsModule {

    @Provides
    @Singleton
    fun provideGetUserInteractor(userRepository: UserRepository,
                              rxJava2Schedulers: RxJava2Schedulers): GetUserInteractor
        = GetUserInteractor(userRepository, rxJava2Schedulers)
}
