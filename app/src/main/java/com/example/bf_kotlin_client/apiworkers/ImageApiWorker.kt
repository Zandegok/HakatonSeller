package com.example.bf_kotlin_client.apiworkers

import android.graphics.Bitmap
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.Headers
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.GlobalVariables

class ImageApiWorker {
    private var globalVariables = GlobalVariables.instance
    fun getPictureByName(controllerName: String, pictureName: String): Bitmap {
        var glideUrl = GlideUrl(
            "http://151.248.113.116:8080/mobile/${controllerName}/getPictureByName/${pictureName}",
            Headers {
                globalVariables.httpHeaders
            }
        )
        var bitmap = try {
            Glide.with(globalVariables.applicationContext).asBitmap()
                .load(glideUrl)
                .error(R.drawable.error)
                .fallback(R.drawable.fallback)
                .submit().get()
        } catch (e: Exception) {
            getSystemBitmapFromDrawableId(R.drawable.error)
        }
        return bitmap
    }

    fun getSystemBitmapFromDrawableId(drawableId: Int): Bitmap {
        return AppCompatResources.getDrawable(globalVariables.applicationContext, drawableId)!!
            .toBitmap(1000, 1000)
    }
}