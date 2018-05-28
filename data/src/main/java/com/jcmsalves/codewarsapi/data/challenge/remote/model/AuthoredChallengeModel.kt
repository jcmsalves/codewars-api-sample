package com.jcmsalves.codewarsapi.data.challenge.remote.model

import com.google.gson.annotations.SerializedName

data class AuthoredChallengesWrapperModel(
    @SerializedName("data")
    val challengeModels: List<AuthoredChallengeModel>)

data class AuthoredChallengeModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("languages")
    val languages: List<String>)
