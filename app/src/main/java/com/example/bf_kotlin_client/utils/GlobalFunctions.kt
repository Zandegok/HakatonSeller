package com.example.bf_kotlin_client.utils

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter




class GlobalFunctions {}
    @BindingAdapter("android:image_bitmap")
    fun setImageBitmap(imageView: ImageView, bitmap: Bitmap
    ) {
        imageView.setImageBitmap(bitmap)
    }
var appConext:Int=0