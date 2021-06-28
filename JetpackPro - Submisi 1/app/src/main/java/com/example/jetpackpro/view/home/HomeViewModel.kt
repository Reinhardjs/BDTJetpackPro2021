package com.example.jetpackpro.view.home

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.model.DataModel
import com.example.jetpackpro.utils.Dummy

class HomeViewModel : ViewModel() {

    fun getListMovie(): List<DataModel> = Dummy.generateDataMovieDummy()

    fun getListTvShow(): List<DataModel> = Dummy.generateDataTvShowDummy()

}