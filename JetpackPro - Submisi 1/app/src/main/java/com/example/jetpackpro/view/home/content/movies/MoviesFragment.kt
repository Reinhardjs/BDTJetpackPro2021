package com.example.jetpackpro.view.home.content.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpro.R
import com.example.jetpackpro.model.DataModel
import com.example.jetpackpro.utils.Constants.TYPE_MOVIE
import com.example.jetpackpro.view.detail.DetailActivity
import com.example.jetpackpro.view.home.HomeViewModel
import com.example.jetpackpro.view.home.content.Adapter
import com.example.jetpackpro.view.home.content.Callback
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment(var page: Int, var title: String) : Fragment(),
    Callback {

    private lateinit var viewModel: HomeViewModel

    companion object {
        @JvmStatic
        fun newInstance(page: Int, title: String): MoviesFragment {
            return MoviesFragment(page, title)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listMovie = viewModel.getListMovie()
        setupRecyclerView(listMovie)
    }

    private fun setupRecyclerView(data: List<DataModel>) {
        rv_movies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = Adapter(this@MoviesFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is Adapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DataModel) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}