package com.example.bf_kotlin_client.utils

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("android:image_bitmap")
fun setImageBitmap(
    imageView: ImageView, bitmap: Bitmap,
) {
    imageView.setImageBitmap(bitmap)
}

@BindingAdapter("android:is_refresh")
fun setRefresh(
    swipeRefreshLayout: SwipeRefreshLayout, value: Boolean,
) {
    swipeRefreshLayout.isRefreshing = value
}

@BindingAdapter("android:on_refresh")
fun setOnRefreshListener(
    swipeRefreshLayout: SwipeRefreshLayout,
    oldValue: SwipeRefreshLayout.OnRefreshListener?,
    newValue: SwipeRefreshLayout.OnRefreshListener?,
) {
    if (oldValue != null) {
        swipeRefreshLayout.setOnRefreshListener(oldValue)
    }
    if (newValue != null) {
        swipeRefreshLayout.setOnRefreshListener(newValue)
    }
}