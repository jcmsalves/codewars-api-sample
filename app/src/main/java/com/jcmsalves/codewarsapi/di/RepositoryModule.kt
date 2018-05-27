package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.data.user.UserRepositoryImpl
import com.jcmsalves.codewarsapi.data.user.local.dao.UserDao
import com.jcmsalves.codewarsapi.data.user.mappers.UserAndLanguagesToUserMapper
import com.jcmsalves.codewarsapi.data.user.mappers.UserModelToUserDbMapper
import com.jcmsalves.codewarsapi.data.user.remote.UserService
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
}
