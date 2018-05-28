package com.jcmsalves.codewarsapi.challenge.completed.viewmodel

import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge

sealed class CompletedChallengesState {
    class Error : CompletedChallengesState()
    class Loading : CompletedChallengesState()
    data class Data(val challenges: List<CompletedChallenge>) : CompletedChallengesState()
}
