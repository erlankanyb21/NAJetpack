package com.loc.newsapp.data.remote.model


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.SourceModel

data class SourceDto(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

fun SourceDto.toDomain() = SourceModel(
    id, name
)