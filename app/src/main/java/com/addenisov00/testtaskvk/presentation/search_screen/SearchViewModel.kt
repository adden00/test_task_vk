package com.addenisov00.testtaskvk.presentation.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.addenisov00.domain.models.GiffItem
import com.addenisov00.domain.usecases.SearchGiffUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchGiffUseCase: SearchGiffUseCase) :
    ViewModel() {
    private val _giffsList = MutableStateFlow(listOf<GiffItem>())
    val giffsList: StateFlow<List<GiffItem>> = _giffsList.asStateFlow()

    private val _isLoadingGiffs = MutableStateFlow(false)
    val isLoadingGiffs: StateFlow<Boolean> = _isLoadingGiffs.asStateFlow()

    init {

    }


    fun searchGiffs(name: String) {
        _isLoadingGiffs.value = true
        viewModelScope.launch {
            val result = searchGiffUseCase(name)
            _giffsList.value = result
            _isLoadingGiffs.value = false
        }
    }

}