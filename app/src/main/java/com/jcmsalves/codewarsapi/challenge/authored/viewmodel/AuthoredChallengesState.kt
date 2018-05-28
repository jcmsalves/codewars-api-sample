package com.jcmsalves.codewarsapi.challenge.authored.viewmodel

import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge

sealed class AuthoredChallengesState {
    class Error : AuthoredChallengesState()
    class Loading : AuthoredChallengesState()
    data class Data(val challenges: List<AuthoredChallenge>) : AuthoredChallengesState()
}
