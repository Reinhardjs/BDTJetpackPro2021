package com.example.jetpackpro3.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro3.R

fun ImageView.loadFromUrl(path: String) {
    Glide.with(this).clear(this)
    Glide.with(this)
        .setDefaultRequestOptions(
            RequestOptions()
//            .placeholder(R.drawable.image_placeholder)
//            .error(R.drawable.image_placeholder)
        ).load(path).into(this)
}