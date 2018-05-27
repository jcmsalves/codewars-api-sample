package com.jcmsalves.codewarsapi.data.user

import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.RankDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserAndLanguages
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb
import com.jcmsalves.codewarsapi.data.user.remote.model.LanguagesModel
import com.jcmsalves.codewarsapi.data.user.remote.model.RankModel
import com.jcmsalves.codewarsapi.data.user.remote.model.RanksModel
import com.jcmsalves.codewarsapi.data.user.remote.model.UserModel

fun getUserModel(): UserModel {
    return UserModel(username = "username",
        name = "name",
        leaderboardPosition = 1L,
        ranks = getRanksModel())
}

fun getRanksModel(): RanksModel {
    return RanksModel(languages = getLanguagesModel(), overall = getRankModel())
}

fun getLanguagesModel(): LanguagesModel {
    return LanguagesModel(kotlin = getRankModel(), java = getRankModel())
}

fun getRankModel(): RankModel {
    return RankModel(score = 55,
        color = "color",
        name = "name",
        rank = 99)
}

fun getUserAndLanguages(): UserAndLanguages {
    val userAndLanguages = UserAndLanguages()
    userAndLanguages.userDb = UserDb(username = "username",
        name = "name",
        leaderboardPosition = 1L,
        overallRank = getRankDb())

    userAndLanguages.languages = mutableListOf(getLanguageDb(), getLanguageDb())

    return userAndLanguages
}

fun getRankDb(): RankDb {
    return RankDb(score = 66,
        color = "color",
        name = "name",
        rank = 88)
}

fun getLanguageDb(): LanguageDb {
    return LanguageDb(
        id = 1L,
        languageName = "language_name",
        rank = getRankDb(),
        username = "username")
}
