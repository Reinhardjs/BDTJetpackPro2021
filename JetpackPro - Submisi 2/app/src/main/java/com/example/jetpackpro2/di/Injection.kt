package com.example.jetpackpro2.di

import com.example.jetpackpro2.data.source.CatalogueRepository
import com.example.jetpackpro2.data.source.remote.RemoteDataSource

object Injection {

    fun provideCatalogRepository(): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}