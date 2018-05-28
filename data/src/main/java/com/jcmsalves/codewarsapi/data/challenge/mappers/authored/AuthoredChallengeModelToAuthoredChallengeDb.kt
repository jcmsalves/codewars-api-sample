package com.jcmsalves.codewarsapi.data.challenge.mappers.authored

import com.jcmsalves.codewarsapi.data.challenge.local.model.AuthoredChallengeDb
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import javax.inject.Inject

class AuthoredChallengeModelToAuthoredChallengeDb @Inject constructor() {

    fun map(from: AuthoredChallenge, username: String): AuthoredChallengeDb {
        return AuthoredChallengeDb(
            id = from.id,
            name = from.name,
            description = from.description,
            tags = from.tags,
            languages = from.languages,
            username = username
        )
    }
}
