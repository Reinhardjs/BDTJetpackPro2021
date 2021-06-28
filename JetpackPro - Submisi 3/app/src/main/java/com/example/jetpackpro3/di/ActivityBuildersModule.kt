package com.example.jetpackpro3.di

import com.example.jetpackpro3.di.home.HomeFragmentBuildersModule
import com.example.jetpackpro3.ui.detail.DetailActivity
import com.example.jetpackpro3.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

}