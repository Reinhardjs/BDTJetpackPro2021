package com.example.jetpackpro3.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.jetpackpro3.data.local.entity.MovieEntity
import com.example.jetpackpro3.data.local.entity.TvShowEntity
import com.example.jetpackpro3.valueobject.Resource

interface CatalogueDataSource {

    fun getNowPlayingMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getListFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getTvShowOnTheAir(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getListFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity>

    fun setFavoriteMovie(movie: MovieEntity)

    fun setFavoriteTvShow(tvShow: TvShowEntity)

}