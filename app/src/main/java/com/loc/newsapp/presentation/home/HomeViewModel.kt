package com.loc.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.loc.newsapp.domain.usecases.news.FetchNewsUseCase
import com.loc.newsapp.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel() {

    val news = fetchNewsUseCase(
        sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
    ).map { pagingData -> pagingData.map { it.toUI() } }
        .cachedIn(viewModelScope)

}