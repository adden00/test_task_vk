package com.addenisov00.domain.repository

import com.addenisov00.domain.models.GiffItem

interface GiffsRepository {
    suspend fun searchGiffs(name: String): List<GiffItem>
}