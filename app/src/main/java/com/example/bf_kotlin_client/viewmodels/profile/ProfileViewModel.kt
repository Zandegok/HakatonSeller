package com.example.bf_kotlin_client.viewmodels.profile

import android.graphics.Bitmap
import android.media.Image
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker

class ProfileViewModel {
    val image = ObservableField<Bitmap>()

    val imageApiWorker = ImageApiWorker()

    init {
        imageApiWorker.getImage("no path") { image.set(it) }
    }
}