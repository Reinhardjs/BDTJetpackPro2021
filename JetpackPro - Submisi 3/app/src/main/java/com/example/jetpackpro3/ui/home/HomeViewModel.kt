package com.example.jetpackpro3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.jetpackpro3.data.CatalogueRepository
import com.example.jetpackpro3.data.local.entity.MovieEntity
import com.example.jetpackpro3.data.local.entity.TvShowEntity
import com.example.jetpackpro3.valueobject.Resource
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val catalogRepository: CatalogueRepository) :
    ViewModel() {

    fun getListNowPlayingMovies(): LiveData<Resource<PagedList<MovieEntity>>> =
        catalogRepository.getNowPlayingMovies()

    fun getListOnTheAirTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> =
        catalogRepository.getTvShowOnTheAir()

}