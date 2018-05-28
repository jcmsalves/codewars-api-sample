package com.jcmsalves.codewarsapi.domain.challenge

data class AuthoredChallenge(
    val id: String,
    val name: String,
    val description: String,
    val tags: List<String>,
    val languages: List<String>)
