package com.jcmsalves.codewarsapi.domain.user.getRecentSearchedUsers

import com.jcmsalves.codewarsapi.domain.TestSchedulers
import com.jcmsalves.codewarsapi.domain.user.Language
import com.jcmsalves.codewarsapi.domain.user.Rank
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class GetRecentSearchedUsersInteractorTest {

    private val mockUserRepository = mock<UserRepository>()

    private lateinit var getRecentSearchedUsersInteractor: GetRecentSearchedUsersInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getRecentSearchedUsersInteractor = GetRecentSearchedUsersInteractor(mockUserRepository, TestSchedulers())
    }

    @Test
    fun shouldReturnErrorWhenItFailsToRecentSearchedUser() {
        // given
        val throwable = Throwable()
        whenever(mockUserRepository.getRecentSearchedUsers()).thenReturn(Single.error(throwable))

        // when
        val testObserver = getRecentSearchedUsersInteractor.execute().test()

        // then
        testObserver.assertError(throwable)
        verify(mockUserRepository).getRecentSearchedUsers()
    }

    @Test
    fun shouldReturnUserWhenItSucceedsToGetUser() {
        // given
        whenever(mockUserRepository.getRecentSearchedUsers()).thenReturn(Single.just(listOf(getUser(), getUser())))

        // when
        val testObserver = getRecentSearchedUsersInteractor.execute().test()

        // then
        testObserver.assertComplete()
        testObserver.assertValue {
            it.size == 2
            it[0]?.name == getUser().name
        }
        verify(mockUserRepository).getRecentSearchedUsers()
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
