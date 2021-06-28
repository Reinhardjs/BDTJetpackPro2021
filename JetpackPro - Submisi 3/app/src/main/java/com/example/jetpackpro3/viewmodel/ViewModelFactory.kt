package com.example.jetpackpro3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackpro3.data.CatalogueRepository
import com.example.jetpackpro3.ui.detail.DetailViewModel
import com.example.jetpackpro3.ui.home.HomeViewModel
import com.example.jetpackpro3.ui.home.content.favorite.FavoriteViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val mCatalogRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mCatalogRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}