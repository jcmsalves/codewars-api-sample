package com.jcmsalves.codewarsapi.domain.challenge.getCompletedChallenges

import com.jcmsalves.codewarsapi.domain.InteractorRequest

data class GetCompletedChallengesRequest(val username: String, val refresh: Boolean) : InteractorRequest
