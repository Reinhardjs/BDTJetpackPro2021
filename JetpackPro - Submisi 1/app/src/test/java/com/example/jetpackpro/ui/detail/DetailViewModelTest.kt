package com.example.jetpackpro.ui.detail

import com.example.jetpackpro.utils.Dummy
import com.example.jetpackpro.view.detail.DetailViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Dummy.generateDataMovieDummy()[0]
    private val dummyTvShow = Dummy.generateDataTvShowDummy()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.name, movie.name)
        assertEquals(dummyMovie.desc, movie.desc)
        assertEquals(dummyMovie.poster, movie.poster)
        assertEquals(dummyMovie.thumbnail, movie.thumbnail)
    }

    @Test
    fun getDetailTvShowById() {
        val tvShow = viewModel.getDetailTvShowById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.name, tvShow.name)
        assertEquals(dummyTvShow.desc, tvShow.desc)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.thumbnail, tvShow.thumbnail)
    }
}