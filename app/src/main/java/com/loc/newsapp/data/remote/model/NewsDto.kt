package com.loc.newsapp.data.remote.model


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.NewsModel

data class NewsDto(
    @SerializedName("articles")
    val articles: List<ArticleDto?>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)

fun NewsDto.toDomain() = NewsModel(
    articleModels = articles?.map { it?.toDomain() },
    status = status,
    totalResults = totalResults
)