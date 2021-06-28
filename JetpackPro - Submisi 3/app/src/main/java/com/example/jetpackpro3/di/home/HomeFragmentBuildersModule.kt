package com.example.jetpackpro3.di.home

import com.example.jetpackpro3.di.home.favorite.FavoriteFragmentBuildersModule
import com.example.jetpackpro3.ui.home.content.favorite.FavoriteFragment
import com.example.jetpackpro3.ui.home.content.movie.MovieFragment
import com.example.jetpackpro3.ui.home.content.tvshow.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment() : MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment() : TvShowFragment

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteFragment() : FavoriteFragment
}