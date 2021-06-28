package com.example.jetpackpro.view.detail

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.model.DataModel
import com.example.jetpackpro.utils.Dummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DataModel> = Dummy.generateDataMovieDummy() as ArrayList<DataModel>
    private fun getListTvShow(): ArrayList<DataModel> = Dummy.generateDataTvShowDummy() as ArrayList<DataModel>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DataModel {
        lateinit var result: DataModel
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): DataModel {
        lateinit var result: DataModel
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }

}