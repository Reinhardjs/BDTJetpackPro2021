package com.example.jetpackpro3.ui.home.content.movie

import com.example.jetpackpro3.data.local.entity.MovieEntity

interface MovieCallback {
    fun onItemClicked(data: MovieEntity)
}