package com.jcmsalves.codewarsapi.data.user.remote.model

import com.jcmsalves.codewarsapi.domain.Mapper
import com.jcmsalves.codewarsapi.domain.user.Language
import com.jcmsalves.codewarsapi.domain.user.Rank
import com.jcmsalves.codewarsapi.domain.user.User

class UserModelToUserMapper : Mapper<UserModel, User> {

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

    override fun map(from: UserModel): User {
        return User(username = from.username,
            name = from.name,
            leaderboardPosition = from.leaderboardPosition,
            overallRank = mapRankModelToRank(from.ranks.rank),
            languages = mapLanguagesModelToLanguages(from.ranks.languages)
        )
    }

    private fun mapRankModelToRank(from: RankModel): Rank {
        return Rank(score = from.score,
            color = from.color,
            name = from.name,
            rank = from.rank)
    }

    private fun mapLanguagesModelToLanguages(from: LanguagesModel): List<Language> {
        val languages: ArrayList<Language> = ArrayList()

        from.kotlin?.let { languages.add(Language(LANGUAGE_KOTLIN, mapRankModelToRank(it))) }
        from.java?.let { languages.add(Language(LANGUAGE_JAVA, mapRankModelToRank(it))) }
        from.coffeescript?.let { languages.add(Language(LANGUAGE_COFFESCRIPT, mapRankModelToRank(it))) }
        from.javascript?.let { languages.add(Language(LANGUAGE_JAVASCRIPT, mapRankModelToRank(it))) }
        from.ruby?.let { languages.add(Language(LANGUAGE_RUBY, mapRankModelToRank(it))) }
        from.scala?.let { languages.add(Language(LANGUAGE_SCALA, mapRankModelToRank(it))) }
        from.python?.let { languages.add(Language(LANGUAGE_PYTHON, mapRankModelToRank(it))) }
        from.php?.let { languages.add(Language(LANGUAGE_PHP, mapRankModelToRank(it))) }

        return languages
    }
}
