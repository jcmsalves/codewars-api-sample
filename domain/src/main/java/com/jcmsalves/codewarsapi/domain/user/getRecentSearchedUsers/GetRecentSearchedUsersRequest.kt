package com.jcmsalves.codewarsapi.domain.user.getRecentSearchedUsers

import com.jcmsalves.codewarsapi.domain.InteractorRequest

data class GetRecentSearchedUsersRequest(val sortByLeaderboard: Boolean) : InteractorRequest
