package com.example.jetpackpro.view.home

import android.os.Bundle
import com.example.jetpackpro.R
import com.example.jetpackpro.base.BaseActivity
import com.example.jetpackpro.view.home.content.PagerAdapter
import com.example.jetpackpro.view.home.content.movies.MoviesFragment
import com.example.jetpackpro.view.home.content.tvshows.TvShowsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeViewModel>() {

    lateinit var adapterViewPager: PagerAdapter
    override val layoutRes: Int = R.layout.activity_home

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbar.title = getString(R.string.toolbar_title)
        setSupportActionBar(toolbar)

        adapterViewPager = PagerAdapter(this, supportFragmentManager)

        adapterViewPager.addFragment(MoviesFragment.newInstance(0, "Page 1"))
        adapterViewPager.addFragment(TvShowsFragment.newInstance(1, "Page 2"))

        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = adapterViewPager

    }

}