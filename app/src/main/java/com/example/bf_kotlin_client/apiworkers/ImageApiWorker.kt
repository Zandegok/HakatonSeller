package com.example.bf_kotlin_client.apiworkers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageFormat
import android.media.Image
import android.media.ImageReader
import com.android.volley.Request
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.Headers
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson
import java.io.ByteArrayInputStream

class ImageApiWorker {
    fun getPictureByName(controllerName: String, pictureName: String): Bitmap {

        var globalVariables = GlobalVariables.instance
//productsCategories
        var glideUrl = GlideUrl(
            "http://151.248.113.116:8080/mobile/${controllerName}/getPictureByName/${pictureName}",
            Headers {
                globalVariables.httpHeaders
            }
        )

        var bitmap = Glide.with(globalVariables.applicationContext).asBitmap()
            .load(glideUrl)
            .error(R.drawable.error)
            .fallback(R.drawable.fallback)
            .submit().get()

        return bitmap

    }
}