package com.jcmsalves.codewarsapi.data.challenge.remote.model

import com.google.gson.annotations.SerializedName

data class DataWrapperModel(
    @SerializedName("data")
    val challengeModels: List<AuthoredChallengeModel>)
