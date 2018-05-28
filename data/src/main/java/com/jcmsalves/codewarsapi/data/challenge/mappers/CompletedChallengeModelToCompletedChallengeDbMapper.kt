package com.jcmsalves.codewarsapi.data.challenge.mappers

import com.jcmsalves.codewarsapi.data.challenge.local.model.CompletedChallengeDb
import com.jcmsalves.codewarsapi.data.challenge.remote.model.CompletedChallengeModel
import javax.inject.Inject

class CompletedChallengeModelToCompletedChallengeDbMapper @Inject constructor() {

    fun map(from: CompletedChallengeModel, username: String): CompletedChallengeDb {
        return CompletedChallengeDb(
            id = from.id,
            name = from.name ?: "",
            completedAt = from.completedAt,
            completedLanguages = from.completedLanguages,
            slug = from.slug ?: "",
            username = username
        )
    }
}
