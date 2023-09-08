package com.loc.newsapp.data.remote.model


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.ArticleModel

data class ArticleDto(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("publishedAt")
    val publishedAt: String? = null,
    @SerializedName("source")
    val source: SourceDto? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("urlToImage")
    val urlToImage: String? = null
)

fun ArticleDto.toDomain() = ArticleModel(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    sourceModel = source?.toDomain(),
    title = title,
    url = url,
    urlToImage = urlToImage
)