package com.example.bf_kotlin_client.utils

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

@BindingAdapter("android:onItemSelected")
fun setOnItemSelected(
    bottomNavigationView: BottomNavigationView,
    listener: NavigationBarView.OnItemSelectedListener?,
) {
    if (listener != null) {
        bottomNavigationView.setOnItemSelectedListener(listener)
    }
}
@BindingAdapter("android:is_back_button")
fun setIsBackButton(
    view: View, enabled: Boolean,
) {
    if (enabled == false) return
    var callback = GlobalVariables.instance.onBackPressedCallback
    view.setOnClickListener { callback.handleOnBackPressed()}
}
@BindingAdapter("android:onBackPressed")
fun onBackPressed(view: View, callback:OnBackPressedCallback?){
    var activity= view.context as AppCompatActivity
    if (callback != null) {
        activity.onBackPressedDispatcher.addCallback(callback)
    }
}