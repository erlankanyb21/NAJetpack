package com.loc.newsapp.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.ArticleModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun fetchNews(sources:List<String>):Flow<PagingData<ArticleModel>>
}