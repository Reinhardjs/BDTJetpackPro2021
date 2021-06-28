package com.example.jetpackpro

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    @SuppressLint("SimpleDateFormat")
    fun toSimpleString(date: Date): String {
        return SimpleDateFormat("EEE, dd MMM yyy").format(date)
    }

}