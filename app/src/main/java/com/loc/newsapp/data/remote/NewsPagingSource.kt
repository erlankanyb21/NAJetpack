package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.data.remote.model.toDomain
import com.loc.newsapp.domain.model.ArticleModel
import com.loc.newsapp.utils.Const

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
) : PagingSource<Int, ArticleModel>() {

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleModel> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.fetchNews(
                sources = sources,
                page = page,
                apiKey = Const.API_KEY,
                query = "sport",
                sortBy = "publishedAt",
            )
            totalNewsCount += newsResponse.articles?.size ?: 0
            val article = newsResponse.articles?.distinctBy { it?.title }
            LoadResult.Page(
                data = article!!.map { it?.toDomain()!! },
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleModel>): Int? {
        return state.anchorPosition?.let {anchorPos ->
            val anchorPage = state.closestPageToPosition(anchorPos)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}