package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.data.challenge.ChallengeRepositoryImpl
import com.jcmsalves.codewarsapi.data.challenge.local.dao.ChallengeDao
import com.jcmsalves.codewarsapi.data.challenge.mappers.AuthoredChallengeModelToAuthoredChallengeDbMapper
import com.jcmsalves.codewarsapi.data.challenge.mappers.CompletedChallengeModelToCompletedChallengeDbMapper
import com.jcmsalves.codewarsapi.data.challenge.remote.ChallengeService
import com.jcmsalves.codewarsapi.data.user.UserRepositoryImpl
import com.jcmsalves.codewarsapi.data.user.local.dao.UserDao
import com.jcmsalves.codewarsapi.data.user.mappers.UserAndLanguagesToUserMapper
import com.jcmsalves.codewarsapi.data.user.mappers.UserModelToUserDbMapper
import com.jcmsalves.codewarsapi.data.user.remote.UserService
import com.jcmsalves.codewarsapi.domain.challenge.ChallengeRepository
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userService: UserService,
        userDao: UserDao,
        userDbMapper: UserModelToUserDbMapper,
        userMapper: UserAndLanguagesToUserMapper
    ): UserRepository = UserRepositoryImpl(userService, userDao, userDbMapper, userMapper)

    @Provides
    @Singleton
    fun provideChallengeRepository(
        challengeService: ChallengeService,
        challengeDao: ChallengeDao,
        completedChallengeDbMapper: CompletedChallengeModelToCompletedChallengeDbMapper,
        authoredChallengeDbMapper: AuthoredChallengeModelToAuthoredChallengeDbMapper
    ): ChallengeRepository = ChallengeRepositoryImpl(challengeService,
        challengeDao,
        completedChallengeDbMapper,
        authoredChallengeDbMapper)
}
