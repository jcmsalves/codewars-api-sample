package com.jcmsalves.codewarsapi.domain.user.getuser

import com.jcmsalves.codewarsapi.domain.TestSchedulers
import com.jcmsalves.codewarsapi.domain.user.Language
import com.jcmsalves.codewarsapi.domain.user.Rank
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.MockitoAnnotations

class GetUserInteractorTest {

    private val mockUserRepository = mock<UserRepository>()

    private lateinit var getUserInteractor: GetUserInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getUserInteractor = GetUserInteractor(mockUserRepository, TestSchedulers())
    }

    @Test
    fun shouldReturnErrorWhenItFailsToGetUser() {
        // given
        val throwable = Throwable()
        whenever(mockUserRepository.getUser(anyString(), any())).thenReturn(Single.error(throwable))

        // when
        val testObserver = getUserInteractor.execute(GetUserRequest("username", true)).test()

        // then
        testObserver.assertError(throwable)
        verify(mockUserRepository).getUser("username", true)
    }

    @Test
    fun shouldReturnUserWhenItSucceedsToGetUser() {
        // given
        whenever(mockUserRepository.getUser(anyString(), any())).thenReturn(Single.just(getUser()))

        // when
        val testObserver = getUserInteractor.execute(GetUserRequest("username", true)).test()

        // then
        testObserver.assertComplete()
        verify(mockUserRepository).getUser("username", true)
    }
}

private fun getUser(): User {
    return User(username = "username",
        name = "name",
        leaderboardPosition = 1L,
        overallRank = getRank(),
        languages = listOf(getLanguage(), getLanguage()))
}

private fun getRank(): Rank {
    return Rank(score = 55,
        color = "color",
        name = "name",
        rank = 99)
}

private fun getLanguage(): Language {
    return Language(languageName = "language_name",
        rank = getRank())
}
