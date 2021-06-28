package com.example.jetpackpro3.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpackpro3.data.remote.api.ApiService
import com.example.jetpackpro3.data.remote.response.MovieResponse
import com.example.jetpackpro3.data.remote.response.TvShowResponse
import com.example.jetpackpro3.data.remote.valueobject.ApiResponse
import com.example.jetpackpro3.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val catalogApiService: ApiService) {

    fun getNowPlayingMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = catalogApiService.getNowPlayingMovies().await()
                resultMovieResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovieResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovieResponse
    }

    fun getTvShowOnTheAir(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = catalogApiService.getTvShowOnTheAir().await()
                resultTvShowResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShowResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShowResponse
    }

}