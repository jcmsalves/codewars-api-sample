package com.jcmsalves.codewarsapi.data.challenge.mappers.completed

import com.jcmsalves.codewarsapi.data.challenge.local.model.CompletedChallengeDb
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import javax.inject.Inject

class CompletedChallengeModelToCompletedChallengeDb @Inject constructor() {

    fun map(from: CompletedChallenge, username: String): CompletedChallengeDb {
        return CompletedChallengeDb(
            id = from.id,
            name = from.name,
            completedAt = from.completedAt,
            completedLanguages = from.completedLanguages,
            slug = from.slug,
            username = username
        )
    }
}
