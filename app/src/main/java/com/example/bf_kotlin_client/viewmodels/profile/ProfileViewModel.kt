package com.example.bf_kotlin_client.viewmodels.profile

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.Headers
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileViewModel {

    private var globalVariables = GlobalVariables.instance

    var image = ObservableField<Bitmap>(GlobalVariables.instance.applicationContext.getDrawable(R.drawable.ic_launcher_background)?.toBitmap())
    var imageApiWorker = ImageApiWorker()

    init {
        // imageApiWorker.getImage("no path") { image.set(it) }

        GlobalScope.launch(Dispatchers.IO) {
            var glideUrl =GlideUrl("http://151.248.113.116:8080/mobile/productsCategories/getPictureByName/milk.jpg",
                Headers {
                    mutableMapOf("API_KEY" to globalVariables.apiKey, "DEVICE_ID" to globalVariables.deviceId)
                })

            var bitmap = Glide.with(GlobalVariables.instance.applicationContext).asBitmap()
                .load(glideUrl)
                .submit().get()

            image.set(bitmap)
        }


    }

}