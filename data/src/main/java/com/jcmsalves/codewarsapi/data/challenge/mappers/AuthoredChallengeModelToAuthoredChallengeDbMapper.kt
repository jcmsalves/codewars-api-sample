package com.jcmsalves.codewarsapi.data.challenge.mappers

import com.jcmsalves.codewarsapi.data.challenge.local.model.AuthoredChallengeDb
import com.jcmsalves.codewarsapi.data.challenge.remote.model.AuthoredChallengeModel
import javax.inject.Inject

class AuthoredChallengeModelToAuthoredChallengeDbMapper @Inject constructor() {

    fun map(from: AuthoredChallengeModel, username: String): AuthoredChallengeDb {
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
