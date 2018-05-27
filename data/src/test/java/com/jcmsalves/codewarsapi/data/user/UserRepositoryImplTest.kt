package com.jcmsalves.codewarsapi.data.user

import com.jcmsalves.codewarsapi.data.user.local.dao.UserDao
import com.jcmsalves.codewarsapi.data.user.mappers.UserAndLanguagesToUserMapper
import com.jcmsalves.codewarsapi.data.user.mappers.UserModelToUserDbMapper
import com.jcmsalves.codewarsapi.data.user.remote.UserService
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.MockitoAnnotations

class UserRepositoryImplTest {

    private val mockUserService = mock<UserService>()
    private val mockUserDao = mock<UserDao>()

    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        userRepository = UserRepositoryImpl(mockUserService,
            mockUserDao,
            UserModelToUserDbMapper(),
            UserAndLanguagesToUserMapper())
    }

    @Test
    fun shouldReturnThrowableWhenFailsToGetUserFromRemote() {
        // given
        val throwable = Throwable()
        whenever(mockUserService.getUser(anyString())).thenReturn(Single.error(throwable))

        // when
        val testObserver = userRepository.getUser(userSearch = "username", refresh = true).test()

        // then
        testObserver.assertError(throwable)
        verify(mockUserService).getUser(userSearch = "username")
    }

    @Test
    fun shouldFetchFromRemoteWhenFailsToGetUserFromLocal() {
        // given
        val throwable = Throwable()
        whenever(mockUserDao.getUserByUsername(anyString())).thenReturn(Single.error(throwable))

        // when
        userRepository.getUser(userSearch = "username", refresh = false).test()

        // then
        verify(mockUserService).getUser(userSearch = "username")
    }

    @Test
    fun shouldReturnUserWhenItSucceedsToFetchFromRemote() {
        // given
        whenever(mockUserService.getUser(anyString())).thenReturn(Single.just(getUserModel()))
        whenever(mockUserDao.getUserByUsername(anyString())).thenReturn(Single.just(getUserAndLanguages()))

        // when
        val testObserver = userRepository.getUser(userSearch = "username", refresh = true).test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertValue{
            it.username == getUserModel().username
        }
        verify(mockUserService).getUser(userSearch = "username")
    }

    @Test
    fun shouldReturnUserWhenItSucceedsToFetchFromLocal() {
        // given
        whenever(mockUserDao.getUserByUsername(anyString())).thenReturn(Single.just(getUserAndLanguages()))

        // when
        val testObserver = userRepository.getUser(userSearch = "username", refresh = false).test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertValue{
            it.username == getUserAndLanguages().userDb?.username
        }
        verify(mockUserDao).getUserByUsername(username = "username")
    }
}
