package com.loc.newsapp.domain.model


import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("articles")
    val articleModels: List<ArticleModel?>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)