package com.example.jetpackpro3.ui.home.content.tvshow

import com.example.jetpackpro3.data.local.entity.TvShowEntity

interface TvShowCallback {
    fun onItemClicked(data: TvShowEntity)
}