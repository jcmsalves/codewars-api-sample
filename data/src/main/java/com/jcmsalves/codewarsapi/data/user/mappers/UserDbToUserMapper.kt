package com.jcmsalves.codewarsapi.data.user.mappers

import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.RankDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb
import com.jcmsalves.codewarsapi.domain.Mapper
import com.jcmsalves.codewarsapi.domain.user.Language
import com.jcmsalves.codewarsapi.domain.user.Rank
import com.jcmsalves.codewarsapi.domain.user.User

class UserDbToUserMapper : Mapper<UserDb, User> {

    override fun map(from: UserDb): User {
        return User(username = from.username,
            name = from.name,
            leaderboardPosition = from.leaderboardPosition,
            overallRank = mapRankDbToRank(from.overallRank),
            languages = mapLanguagesDbToLanguages(from.languages))
    }


    private fun mapRankDbToRank(from: RankDb): Rank {
        return Rank(score = from.score,
            color = from.color,
            name = from.name,
            rank = from.rank)
    }

    private fun mapLanguagesDbToLanguages(from: List<LanguageDb>): List<Language> {
        return from.map { mapLanguageDbToLanguage(it) }
    }

    private fun mapLanguageDbToLanguage(from: LanguageDb) : Language {
        return Language(languageName = from.languageName,
            rank = mapRankDbToRank(from.rank))
    }
}
