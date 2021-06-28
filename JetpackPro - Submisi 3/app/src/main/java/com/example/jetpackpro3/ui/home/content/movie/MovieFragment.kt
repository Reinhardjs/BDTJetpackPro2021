package com.example.jetpackpro3.ui.home.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpro3.R
import com.example.jetpackpro3.data.local.entity.MovieEntity
import com.example.jetpackpro3.ui.detail.DetailActivity
import com.example.jetpackpro3.ui.home.HomeViewModel
import com.example.jetpackpro3.utils.Helper.TYPE_MOVIE
import com.example.jetpackpro3.valueobject.Status
import com.example.jetpackpro3.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class MovieFragment : DaggerFragment(), MovieCallback {

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        activity?.let { setupViewModel(it) }
        observeListMovies()

    }

    private fun setupViewModel(fragmentActivity: FragmentActivity) {
        viewModel = ViewModelProvider(fragmentActivity, factory)[HomeViewModel::class.java]
    }

    private fun observeListMovies() {
        viewModel.getListNowPlayingMovies().observe(viewLifecycleOwner, Observer { listMovie ->
            if (listMovie != null) {
                when (listMovie.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        progress_bar.visibility = View.GONE
                        rv_movie.adapter?.let { adapter ->
                            when (adapter) {
                                is MovieAdapter -> {
                                    adapter.submitList(listMovie.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(
                            context,
                            "Check your internet connection",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rv_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MovieAdapter(this@MovieFragment)
        }
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.movieId)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}