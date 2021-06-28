package com.example.jetpackpro2.data.source

import androidx.lifecycle.LiveData
import com.example.jetpackpro2.data.DataModel

interface CatalogueDataSource {

    fun getNowPlayingMovies(): LiveData<List<DataModel>>

    fun getMovieDetail(movieId: Int): LiveData<DataModel>

    fun getTvShowOnTheAir(): LiveData<List<DataModel>>

    fun getTvShowDetail(tvShowId: Int): LiveData<DataModel>

}