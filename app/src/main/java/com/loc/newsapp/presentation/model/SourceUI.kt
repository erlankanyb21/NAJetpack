package com.loc.newsapp.presentation.model


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.SourceModel

data class SourceUI(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

fun SourceModel.toUI() = SourceUI(
    id, name
)