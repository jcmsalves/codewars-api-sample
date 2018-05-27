package com.jcmsalves.codewarsapi.data.user.remote.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("leaderboardPosition")
    val leaderboardPosition: Long,
    @SerializedName("ranks")
    val ranks: RanksModel
)

data class RanksModel(@SerializedName("languages")
                      val languages: LanguagesModel,
                      @SerializedName("overall")
                      val rank: RankModel)

data class RankModel(@SerializedName("score")
                     val score: Int,
                     @SerializedName("color")
                     val color: String,
                     @SerializedName("name")
                     val name: String,
                     @SerializedName("rank")
                     val rank: Int = 0)

data class LanguagesModel(@SerializedName("kotlin")
                          val kotlin: RankModel?,
                          @SerializedName("java")
                          val java: RankModel?,
                          @SerializedName("coffeescript")
                          val coffeescript: RankModel?,
                          @SerializedName("javascript")
                          val javascript: RankModel?,
                          @SerializedName("ruby")
                          val ruby: RankModel?,
                          @SerializedName("scala")
                          val scala: RankModel?,
                          @SerializedName("python")
                          val python: RankModel?,
                          @SerializedName("php")
                          val php: RankModel?)
