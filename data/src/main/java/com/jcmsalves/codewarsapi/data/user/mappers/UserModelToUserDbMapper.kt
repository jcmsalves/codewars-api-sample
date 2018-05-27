package com.jcmsalves.codewarsapi.data.user.mappers

import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.RankDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb
import com.jcmsalves.codewarsapi.data.user.remote.model.LanguagesModel
import com.jcmsalves.codewarsapi.data.user.remote.model.RankModel
import com.jcmsalves.codewarsapi.data.user.remote.model.UserModel
import com.jcmsalves.codewarsapi.domain.Mapper

class UserModelToUserDbMapper : Mapper<UserModel, UserDb> {

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
            overallRank = mapRankModelToRankDb(from.ranks.rank),
            languages = mapLanguagesModelToLanguagesDb(from.ranks.languages, from.username)
        )
    }

    private fun mapRankModelToRankDb(from: RankModel): RankDb {
        return RankDb(score = from.score,
            color = from.color,
            name = from.name,
            rank = from.rank)
    }

    private fun mapLanguagesModelToLanguagesDb(from: LanguagesModel, username: String): List<LanguageDb> {
        val languagesDb: ArrayList<LanguageDb> = ArrayList()

        from.kotlin?.let { languagesDb.add(LanguageDb(LANGUAGE_KOTLIN, mapRankModelToRankDb(it), username)) }
        from.java?.let { languagesDb.add(LanguageDb(LANGUAGE_JAVA, mapRankModelToRankDb(it), username)) }
        from.coffeescript?.let { languagesDb.add(LanguageDb(LANGUAGE_COFFESCRIPT, mapRankModelToRankDb(it), username)) }
        from.javascript?.let { languagesDb.add(LanguageDb(LANGUAGE_JAVASCRIPT, mapRankModelToRankDb(it), username)) }
        from.ruby?.let { languagesDb.add(LanguageDb(LANGUAGE_RUBY, mapRankModelToRankDb(it), username)) }
        from.scala?.let { languagesDb.add(LanguageDb(LANGUAGE_SCALA, mapRankModelToRankDb(it), username)) }
        from.python?.let { languagesDb.add(LanguageDb(LANGUAGE_PYTHON, mapRankModelToRankDb(it), username)) }
        from.php?.let { languagesDb.add(LanguageDb(LANGUAGE_PHP, mapRankModelToRankDb(it), username)) }

        return languagesDb
    }
}
