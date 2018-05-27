package com.jcmsalves.codewarsapi.domain.user

data class User(val username: String,
                val name: String?,
                val leaderboardPosition: Long,
                val overallRank: Rank,
                val languages: List<Language>
)

data class Rank(val score: Int,
                val color: String,
                val name: String,
                val rank: Int = 0)

data class Language(val languageName: String,
                    val rank: Rank)
