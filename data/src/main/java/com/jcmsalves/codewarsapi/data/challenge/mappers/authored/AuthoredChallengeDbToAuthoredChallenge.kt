package com.jcmsalves.codewarsapi.data.challenge.mappers.authored

import com.jcmsalves.codewarsapi.data.challenge.local.model.AuthoredChallengeDb
import com.jcmsalves.codewarsapi.domain.Mapper
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import javax.inject.Inject

class AuthoredChallengeDbToAuthoredChallenge @Inject constructor() : Mapper<AuthoredChallengeDb, AuthoredChallenge> {

    override fun map(from: AuthoredChallengeDb): AuthoredChallenge {
        return AuthoredChallenge(
            id = from.id,
            name = from.name,
            description = from.description,
            tags = from.tags,
            languages = from.languages
        )
    }
}
