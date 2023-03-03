package com.addenisov00.domain.usecases

import com.addenisov00.domain.models.GiffItem
import com.addenisov00.domain.repository.GiffsRepository

class SearchGiffUseCase(private val repository: GiffsRepository) {
    suspend operator fun invoke(name: String): List<GiffItem> {
        return repository.searchGiffs(name)

    }
}