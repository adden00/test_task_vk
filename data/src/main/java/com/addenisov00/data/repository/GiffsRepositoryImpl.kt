package com.addenisov00.data.repository

import com.addenisov00.data.models.toDomain
import com.addenisov00.data.network.GifsNetworkService
import com.addenisov00.domain.models.GiffItem
import com.addenisov00.domain.repository.GiffsRepository

class GiffsRepositoryImpl(private val networkService: GifsNetworkService) : GiffsRepository {
    override suspend fun searchGiffs(name: String): List<GiffItem> {
        val result = networkService.searchGifs(name)
        return result?.data?.map { it.toDomain() } ?: listOf()

    }
}