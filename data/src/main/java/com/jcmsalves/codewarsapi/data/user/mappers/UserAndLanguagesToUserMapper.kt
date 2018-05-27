package com.jcmsalves.codewarsapi.data.user.mappers

import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.RankDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserAndLanguages
import com.jcmsalves.codewarsapi.domain.Mapper
import com.jcmsalves.codewarsapi.domain.user.Language
import com.jcmsalves.codewarsapi.domain.user.Rank
import com.jcmsalves.codewarsapi.domain.user.User
import javax.inject.Inject

class UserAndLanguagesToUserMapper @Inject constructor() : Mapper<UserAndLanguages, User?> {

    override fun map(from: UserAndLanguages): User? {
        return from.userDb?.let {
            User(username = it.username,
                name = it.name,
                leaderboardPosition = it.leaderboardPosition,
                overallRank = mapRankDbRank(it.overallRank),
                languages = from.languages.map { mapLanguageDbToLanguage(it) }
            )
        }
    }

    private fun mapLanguageDbToLanguage(from: LanguageDb): Language {
        return Language(languageName = from.languageName,
            rank = mapRankDbRank(from.rank))
    }

    private fun mapRankDbRank(from: RankDb): Rank {
        return Rank(score = from.score,
            color = from.color,
            name = from.name,
            rank = from.rank)
    }
}
