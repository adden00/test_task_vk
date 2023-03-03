package com.addenisov00.testtaskvk.common.di

import com.addenisov00.domain.repository.GiffsRepository
import com.addenisov00.domain.usecases.SearchGiffUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DonainModule {

    @Provides
    fun provideSearchGiffUseCase(repository: GiffsRepository) = SearchGiffUseCase(repository)
}