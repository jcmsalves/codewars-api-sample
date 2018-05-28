package com.jcmsalves.codewarsapi.data.challenge.mappers.completed

import com.jcmsalves.codewarsapi.data.challenge.local.model.CompletedChallengeDb
import com.jcmsalves.codewarsapi.domain.Mapper
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import javax.inject.Inject

class CompletedChallengeDbToCompletedChallenge @Inject constructor() : Mapper<CompletedChallengeDb, CompletedChallenge> {

    override fun map(from: CompletedChallengeDb): CompletedChallenge {
        return CompletedChallenge(
            id = from.id,
            name = from.name,
            completedAt = from.completedAt,
            completedLanguages = from.completedLanguages,
            slug = from.slug
        )
    }
}
