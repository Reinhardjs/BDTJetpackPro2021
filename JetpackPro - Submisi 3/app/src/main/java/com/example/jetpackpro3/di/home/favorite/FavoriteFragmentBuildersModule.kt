package com.example.jetpackpro3.di.home.favorite

import com.example.jetpackpro3.ui.home.content.favorite.movie.FavoriteMovieFragment
import com.example.jetpackpro3.ui.home.content.favorite.tvshow.FavoriteTvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment(): FavoriteMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment(): FavoriteTvShowFragment
}