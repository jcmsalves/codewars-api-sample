package com.jcmsalves.codewarsapi.domain.challenge.getauthoredchallenges

import com.jcmsalves.codewarsapi.domain.InteractorRequest

data class GetAuthoredChallengesRequest(val username: String, val refresh: Boolean) : InteractorRequest
