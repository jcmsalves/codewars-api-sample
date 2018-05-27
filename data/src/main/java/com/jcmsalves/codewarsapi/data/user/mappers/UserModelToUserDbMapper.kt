package com.jcmsalves.codewarsapi.data.user.mappers

import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.RankDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb
import com.jcmsalves.codewarsapi.data.user.remote.model.LanguagesModel
import com.jcmsalves.codewarsapi.data.user.remote.model.RankModel
import com.jcmsalves.codewarsapi.data.user.remote.model.UserModel
import com.jcmsalves.codewarsapi.domain.Mapper
import javax.inject.Inject

class UserModelToUserDbMapper @Inject constructor() : Mapper<UserModel, UserDb> {

    companion object {
        private const val LANGUAGE_KOTLIN = "kotlin"
        private const val LANGUAGE_JAVA = "java"
        private const val LANGUAGE_COFFESCRIPT = "coffeescript"
        private const val LANGUAGE_JAVASCRIPT = "javascript"
        private const val LANGUAGE_RUBY = "ruby"
        private const val LANGUAGE_SCALA = "scala"
        private const val LANGUAGE_PYTHON = "python"
        private const val LANGUAGE_PHP = "php"
    }

    override fun map(from: UserModel): UserDb {
        return UserDb(username = from.username,
            name = from.name,
            leaderboardPosition = from.leaderboardPosition,
            overallRank = mapRankModelToRankDb(from.ranks.rank))
    }

    private fun mapRankModelToRankDb(from: RankModel): RankDb {
        return RankDb(score = from.score,
            color = from.color,
            name = from.name,
            rank = from.rank)
    }

    fun mapLanguagesModelToLanguagesDb(from: LanguagesModel, username: String): List<LanguageDb> {
        val languagesDb: ArrayList<LanguageDb> = ArrayList()

        from.kotlin?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_KOTLIN,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.java?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_JAVA,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.coffeescript?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_COFFESCRIPT,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.javascript?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_JAVASCRIPT,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.ruby?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_RUBY,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.scala?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_SCALA,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.python?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_PYTHON,
            rank = mapRankModelToRankDb(it),
            username = username)) }
        from.php?.let { languagesDb.add(LanguageDb(languageName = LANGUAGE_PHP,
            rank = mapRankModelToRankDb(it),
            username = username)) }

        return languagesDb
    }
}
