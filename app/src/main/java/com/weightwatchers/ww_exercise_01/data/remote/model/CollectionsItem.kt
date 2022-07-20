package com.weightwatchers.ww_exercise_01.data.remote.model


import com.google.gson.annotations.SerializedName

data class CollectionsItem(
    @SerializedName("filter")
    val filter: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("title")
    val title: String? = null
)
