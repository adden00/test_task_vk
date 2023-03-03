package com.addenisov00.testtaskvk.common.di

import com.addenisov00.data.Constants
import com.addenisov00.data.network.GifsApiClient
import com.addenisov00.data.network.GifsNetworkService
import com.addenisov00.data.repository.GiffsRepositoryImpl
import com.addenisov00.domain.repository.GiffsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideApiClient(): GifsApiClient = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(GifsApiClient::class.java)

    @Provides
    @Singleton
    fun provideGiffsRepository(networkService: GifsNetworkService): GiffsRepository =
        GiffsRepositoryImpl(networkService)

}