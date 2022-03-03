package com.example.bf_kotlin_client.utils

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

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
@BindingAdapter("android:onItemSelected")
fun setOnItemSelected(
    bottomNavigationView: BottomNavigationView,
    oldValue: NavigationBarView.OnItemSelectedListener?,
    newValue: NavigationBarView.OnItemSelectedListener?,
) {
    if (oldValue != null) {
        bottomNavigationView.setOnItemSelectedListener(oldValue)
    }
    if (newValue != null) {
        bottomNavigationView.setOnItemSelectedListener(newValue)
    }
}