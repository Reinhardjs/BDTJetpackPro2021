package com.example.jetpackpro.view.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackpro.R
import com.example.jetpackpro.model.DataModel
import com.example.jetpackpro.utils.Constants.TYPE_MOVIE
import com.example.jetpackpro.utils.Constants.TYPE_TVSHOW
import com.example.jetpackpro.utils.Helper.setImage
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val viewModel = ViewModelProvider(
            this@DetailActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        setupToolbar()

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_movie))
            id?.let {
                viewModel.setMovieId(it)
            }
            result = viewModel.getDetailMovieById()

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_tvshow))
            id?.let {
                viewModel.setTvShowId(it)
            }
            result = viewModel.getDetailTvShowById()
        }

        tv_detail_name.text = result.name
        tv_detail_desc.text = result.desc
        setImage(this@DetailActivity, result.poster, img_detail_poster)
        setImage(this@DetailActivity, result.thumbnail, img_detail_hightlight)
    }

    private fun setupToolbar() {
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.setExpandedTitleColor(Color.TRANSPARENT)
    }

    private fun setupToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}