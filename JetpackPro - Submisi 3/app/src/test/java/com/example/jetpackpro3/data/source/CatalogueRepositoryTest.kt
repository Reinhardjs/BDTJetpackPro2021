package com.example.jetpackpro3.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.jetpackpro3.LiveDataTestUtil
import com.example.jetpackpro3.PagedListUtil
import com.example.jetpackpro3.data.local.LocalDataSource
import com.example.jetpackpro3.data.local.entity.MovieEntity
import com.example.jetpackpro3.data.local.entity.TvShowEntity
import com.example.jetpackpro3.data.remote.RemoteDataSource
import com.example.jetpackpro3.utils.DataDummy
import com.example.jetpackpro3.valueobject.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val catalogRepository = FakeCatalogRepository(remote, local)

    private val listMovie = DataDummy.generateDataMovieDummy()
    private val listTvShow = DataDummy.generateDataTvShowDummy()
    private val movie = DataDummy.generateDataMovieDummy()[0]
    private val tvShow = DataDummy.generateDataTvShowDummy()[0]

    @Test
    fun getNowPlayingMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getListMovies()).thenReturn(dataSourceFactory)
        catalogRepository.getNowPlayingMovies()

        val movieEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataMovieDummy()))
        verify(local).getListMovies()
        org.junit.Assert.assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getTvShowOnTheAir() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListTvShows()).thenReturn(dataSourceFactory)
        catalogRepository.getTvShowOnTheAir()

        val tvShowEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataTvShowDummy()))
        verify(local).getListTvShows()
        org.junit.Assert.assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        `when`(local.getDetailMovie(movie.movieId)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movie.movieId))
        verify(local).getDetailMovie(movie.movieId)
        org.junit.Assert.assertNotNull(data)
        assertEquals(movie.movieId, data.movieId)
    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(local.getDetailTvShow(tvShow.tvShowId)).thenReturn(dummyTvShow)

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShowDetail(tvShow.tvShowId))
        verify(local).getDetailTvShow(tvShow.tvShowId)
        org.junit.Assert.assertNotNull(data)
        assertEquals(tvShow.tvShowId, data.tvShowId)
    }

    @Test
    fun getListFavoriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getListFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogRepository.getListFavoriteMovies()

        val movieEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataMovieDummy()))
        verify(local).getListFavoriteMovies()
        org.junit.Assert.assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getListFavoriteTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogRepository.getListFavoriteTvShows()

        val tvShowEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataTvShowDummy()))
        verify(local).getListFavoriteTvShows()
        org.junit.Assert.assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }
}