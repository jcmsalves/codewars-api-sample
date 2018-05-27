package com.jcmsalves.codewarsapi.data.user

import com.jcmsalves.codewarsapi.data.user.local.dao.UserDao
import com.jcmsalves.codewarsapi.data.user.mappers.UserAndLanguagesToUserMapper
import com.jcmsalves.codewarsapi.data.user.mappers.UserModelToUserDbMapper
import com.jcmsalves.codewarsapi.data.user.remote.UserService
import com.jcmsalves.codewarsapi.data.user.remote.model.UserModel
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao,
    private val userDbMapper: UserModelToUserDbMapper,
    private val userMapper: UserAndLanguagesToUserMapper
) : UserRepository {

    override fun getUser(userSearch: String, refresh: Boolean): Single<User?> {
        return when (refresh) {
            true -> fetchFromRemote(userSearch)
            false -> fetchFromDb(userSearch)
        }
    }

    private fun fetchFromDb(userSearch: String): Single<User?> {
        return userDao.getUserByUsername(userSearch)
            .map { userMapper.map(it) }
    }

    private fun fetchFromRemote(userSearch: String): Single<User?> {
        return userService.getUser(userSearch)
            .map { storeUser(it) }
            .flatMap { fetchFromDb(userSearch) }
    }

    private fun storeUser(userModel: UserModel) {
        userDao.insertUser(userDbMapper.map(userModel))
        userDbMapper.mapLanguagesModelToLanguagesDb(userModel.ranks.languages, userModel.username)
            .forEach { userDao.insertUserLanguage(it) }
    }

    override fun getRecentSearchedUsers(): Single<List<User?>> {
        return userDao.getUsers()
            .map { it.map { userMapper.map(it) }.take(5) }
    }

}
