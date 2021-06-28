package com.example.jetpackpro3.ui.home.content.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.jetpackpro3.data.CatalogueRepository
import com.example.jetpackpro3.data.local.entity.MovieEntity
import com.example.jetpackpro3.data.local.entity.TvShowEntity
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val catalogRepository: CatalogueRepository) : ViewModel() {

    fun getListFavoriteMovie(): LiveData<PagedList<MovieEntity>> = catalogRepository.getListFavoriteMovies()

    fun getListFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> = catalogRepository.getListFavoriteTvShows()
}