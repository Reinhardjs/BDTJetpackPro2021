package com.example.jetpackpro.utils

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

object Helper {

    fun setImage(context: Context, imagePath: String, imageView: ImageView) {
        Picasso.with(context).load(imagePath).into(imageView)
    }

}