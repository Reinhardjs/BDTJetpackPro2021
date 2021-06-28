package com.example.jetpackpro2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro2.data.DataModel
import com.example.jetpackpro2.data.source.CatalogueRepository

class DetailViewModel(private val catalogRepository: CatalogueRepository) : ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<DataModel> =
        catalogRepository.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<DataModel> = catalogRepository.getTvShowDetail(
        tvShowId
    )
}