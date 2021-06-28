package com.example.jetpackpro3.ui.home.content.tvshow

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
import com.example.jetpackpro3.data.local.entity.TvShowEntity
import com.example.jetpackpro3.ui.detail.DetailActivity
import com.example.jetpackpro3.ui.home.HomeViewModel
import com.example.jetpackpro3.utils.Helper.TYPE_TVSHOW
import com.example.jetpackpro3.valueobject.Status
import com.example.jetpackpro3.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class TvShowFragment : DaggerFragment(), TvShowCallback {

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        activity?.let { setupViewModel(it) }
        observeListTvShow()

    }

    private fun setupRecyclerView() {
        rv_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvShowAdapter(this@TvShowFragment)
        }
    }

    private fun setupViewModel(fragmentActivity: FragmentActivity) {
        fragmentActivity.let {
            viewModel = ViewModelProvider(
                it,
                factory
            )[HomeViewModel::class.java]
        }
    }

    private fun observeListTvShow() {
        viewModel.getListOnTheAirTvShows().observe(viewLifecycleOwner, Observer { listTvShow ->
            if (listTvShow != null) {
                when (listTvShow.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        progress_bar.visibility = View.GONE
                        rv_tvshow.adapter?.let { adapter ->
                            when (adapter) {
                                is TvShowAdapter -> {
                                    adapter.submitList(listTvShow.data)
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


    override fun onItemClicked(data: TvShowEntity) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.tvShowId)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}