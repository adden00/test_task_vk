package com.addenisov00.data.network

import android.util.Log
import com.addenisov00.data.Constants
import com.addenisov00.data.models.SearchGifItem
import javax.inject.Inject

class GifsNetworkService @Inject constructor(private val api: GifsApiClient) {
    suspend fun searchGifs(name: String): SearchGifItem? {
        var result: SearchGifItem? = null
        try {
            result = api.searchGifByName(Constants.API_KEY, name).body()

        } catch (e: java.lang.Exception) {
            Log.d("MyLog", e.toString())
        }
        return result
    }

}