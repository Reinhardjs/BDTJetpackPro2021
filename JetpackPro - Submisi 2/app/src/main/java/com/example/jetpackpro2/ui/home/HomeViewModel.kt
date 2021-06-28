package com.example.jetpackpro2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro2.data.DataModel
import com.example.jetpackpro2.data.source.CatalogueRepository

class HomeViewModel(private val catalogRepository: CatalogueRepository) : ViewModel() {

    fun getListNowPlayingMovies(): LiveData<List<DataModel>> = catalogRepository.getNowPlayingMovies()

    fun getListOnTheAirTvShows(): LiveData<List<DataModel>> = catalogRepository.getTvShowOnTheAir()

}