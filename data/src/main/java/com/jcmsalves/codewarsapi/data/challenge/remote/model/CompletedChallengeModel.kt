package com.jcmsalves.codewarsapi.data.challenge.remote.model

import com.google.gson.annotations.SerializedName

data class CompletedChallengeModel(
    @SerializedName("completedAt")
    val completedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("completedLanguages")
    val completedLanguages: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("slug")
    val slug: String)
