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
                      val overall: RankModel)

data class RankModel(@SerializedName("score")
                     val score: Int,
                     @SerializedName("color")
                     val color: String,
                     @SerializedName("name")
                     val name: String,
                     @SerializedName("rank")
                     val rank: Int = 0)

data class LanguagesModel(@SerializedName("kotlin")
                          val kotlin: RankModel? =  null,
                          @SerializedName("java")
                          val java: RankModel? =  null,
                          @SerializedName("coffeescript")
                          val coffeescript: RankModel? =  null,
                          @SerializedName("javascript")
                          val javascript: RankModel? =  null,
                          @SerializedName("ruby")
                          val ruby: RankModel? =  null,
                          @SerializedName("scala")
                          val scala: RankModel? =  null,
                          @SerializedName("python")
                          val python: RankModel? =  null,
                          @SerializedName("php")
                          val php: RankModel? =  null)
