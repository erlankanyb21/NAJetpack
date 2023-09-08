package com.loc.newsapp.presentation.model


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.ArticleModel
import com.loc.newsapp.presentation.model.SourceUI

data class ArticleUI(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("publishedAt")
    val publishedAt: String? = null,
    @SerializedName("source")
    val sourceUI: SourceUI? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("urlToImage")
    val urlToImage: String? = null
)

fun ArticleModel.toUI() = ArticleUI(
    author,
    content,
    description,
    publishedAt,
    sourceUI = sourceModel?.toUI(),
    title,
    url,
    urlToImage
)