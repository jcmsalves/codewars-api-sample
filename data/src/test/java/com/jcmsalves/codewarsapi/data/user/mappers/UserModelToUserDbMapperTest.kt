package com.jcmsalves.codewarsapi.data.user.mappers

import com.jcmsalves.codewarsapi.data.user.getUserModel
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class UserModelToUserDbMapperTest {

    private val mapper = UserModelToUserDbMapper()

    @Test
    fun shouldMapUserNetworkModelToDbModel() {
        // given
        val userModel = getUserModel()

        // when
        val expectedUserDb = mapper.map(userModel)

        // then
        SoftAssertions().apply {
            assertThat(expectedUserDb.username).isEqualTo(userModel.username)
            assertThat(expectedUserDb.name).isEqualTo(userModel.name)
            assertThat(expectedUserDb.leaderboardPosition).isEqualTo(userModel.leaderboardPosition)
            assertThat(expectedUserDb.overallRank.color).isEqualTo(userModel.ranks.overall.color)
            assertThat(expectedUserDb.overallRank.name).isEqualTo(userModel.ranks.overall.name)
            assertThat(expectedUserDb.overallRank.rank).isEqualTo(userModel.ranks.overall.rank)
            assertThat(expectedUserDb.overallRank.score).isEqualTo(userModel.ranks.overall.score)
        }.assertAll()
    }

    @Test
    fun shouldMapLanguagesNetworkModelToDbModel() {
        // given
        val userModel = getUserModel()

        // when
        val expectedLanguages = mapper.mapLanguagesModelToLanguagesDb(userModel.ranks.languages, userModel.username)

        SoftAssertions().apply {
            assertThat(expectedLanguages.size).isEqualTo(2)
            assertThat(expectedLanguages[0].languageName).isEqualTo(UserModelToUserDbMapper.LANGUAGE_KOTLIN)
            assertThat(expectedLanguages[1].languageName).isEqualTo(UserModelToUserDbMapper.LANGUAGE_JAVA)
        }.assertAll()
    }
}
