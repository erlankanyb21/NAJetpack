package com.loc.newsapp.domain.model


import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)