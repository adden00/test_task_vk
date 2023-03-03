package com.addenisov00.data.network

import com.addenisov00.data.models.SearchGifItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsApiClient {
    @GET("gifs/search")
    suspend fun searchGifByName(
        @Query("api_key") apiKey: String,
        @Query("q") name: String
    ): Response<SearchGifItem>
}