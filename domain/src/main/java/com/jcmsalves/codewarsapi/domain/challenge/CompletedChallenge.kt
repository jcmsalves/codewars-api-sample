package com.jcmsalves.codewarsapi.domain.challenge

data class CompletedChallenge(
    val completedAt: String,
    val name: String,
    val completedLanguages: List<String>,
    val id: String,
    val slug: String)
