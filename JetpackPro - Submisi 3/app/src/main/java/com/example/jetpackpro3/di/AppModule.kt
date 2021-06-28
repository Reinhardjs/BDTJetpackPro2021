package com.example.jetpackpro3.di

import android.app.Application
import com.example.jetpackpro3.data.CatalogueRepository
import com.example.jetpackpro3.data.local.LocalDataSource
import com.example.jetpackpro3.data.local.room.CatalogDao
import com.example.jetpackpro3.data.local.room.CatalogDatabase
import com.example.jetpackpro3.data.remote.RemoteDataSource
import com.example.jetpackpro3.data.remote.api.ApiService
import com.example.jetpackpro3.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideCatalogDatabase(application: Application): CatalogDatabase =
            CatalogDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideCatalogDao(catalogDatabase: CatalogDatabase): CatalogDao =
            catalogDatabase.catalogDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(catalogDao: CatalogDao): LocalDataSource =
            LocalDataSource(catalogDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideCatalogRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ): CatalogueRepository = CatalogueRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(catalogRepository: CatalogueRepository): ViewModelFactory =
            ViewModelFactory(catalogRepository)

    }
}