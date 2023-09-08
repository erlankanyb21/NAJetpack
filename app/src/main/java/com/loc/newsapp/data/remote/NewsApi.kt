package com.loc.newsapp.data.remote

import com.loc.newsapp.data.remote.model.NewsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun fetchNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String,
    ): NewsDto
}