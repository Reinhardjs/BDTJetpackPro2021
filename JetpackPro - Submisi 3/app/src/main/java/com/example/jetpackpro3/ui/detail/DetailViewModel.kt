package com.example.jetpackpro3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro3.data.CatalogueRepository
import com.example.jetpackpro3.data.local.entity.MovieEntity
import com.example.jetpackpro3.data.local.entity.TvShowEntity
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val catalogRepository: CatalogueRepository) :
    ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        catalogRepository.getTvShowDetail(tvShowId)

    fun setFavoriteMovie(movie: MovieEntity) {
        catalogRepository.setFavoriteMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        catalogRepository.setFavoriteTvShow(tvShow)
    }
}