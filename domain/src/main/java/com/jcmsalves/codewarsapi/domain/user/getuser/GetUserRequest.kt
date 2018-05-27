package com.jcmsalves.codewarsapi.domain.user.getuser

import com.jcmsalves.codewarsapi.domain.InteractorRequest

data class GetUserRequest(val userSearch: String, val refresh: Boolean) : InteractorRequest
