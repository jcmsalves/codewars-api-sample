package com.jcmsalves.codewarsapi.data.user.mappers

import com.jcmsalves.codewarsapi.data.user.getUserAndLanguages
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class UserAndLanguagesToUserMapperTest {

    private val mapper = UserAndLanguagesToUserMapper()

    @Test
    fun shouldMapUsersAndLanguagesModelToDomainModel() {
        // given
        val userAndLanguages = getUserAndLanguages()

        // when
        val expectedUser = mapper.map(userAndLanguages)

        // then
        SoftAssertions().apply {
            assertThat(expectedUser?.username).isEqualTo(userAndLanguages.userDb?.username)
            assertThat(expectedUser?.name).isEqualTo(userAndLanguages.userDb?.name)
            assertThat(expectedUser?.overallRank?.color).isEqualTo(userAndLanguages.userDb?.overallRank?.color)
            assertThat(expectedUser?.overallRank?.score).isEqualTo(userAndLanguages.userDb?.overallRank?.score)
            assertThat(expectedUser?.overallRank?.rank).isEqualTo(userAndLanguages.userDb?.overallRank?.rank)
            assertThat(expectedUser?.overallRank?.name).isEqualTo(userAndLanguages.userDb?.overallRank?.name)
            assertThat(expectedUser?.leaderboardPosition).isEqualTo(userAndLanguages.userDb?.leaderboardPosition)
            assertThat(expectedUser?.languages?.size).isEqualTo(2)
            assertThat(expectedUser?.languages?.get(0)?.languageName).isEqualTo("language_name")
        }.assertAll()
    }
}
