package com.loc.newsapp.presentation.model


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.NewsModel

data class NewsUI(
    @SerializedName("articles")
    val articleModels: List<ArticleUI?>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)

fun NewsModel.toUI() = NewsUI(
    articleModels = articleModels?.map { it?.toUI() },
    status = status,
    totalResults = totalResults
)