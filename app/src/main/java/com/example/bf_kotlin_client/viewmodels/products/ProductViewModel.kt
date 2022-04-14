package com.example.bf_kotlin_client.viewmodels.products

import android.graphics.Bitmap
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.dtos.entities.Product
import kotlinx.coroutines.*

class ProductViewModel {
    private var imageApiWorker = ImagesApiWorker()
    var product: Product = Product()
        set(value) {
            field = value
            GlobalScope.launch(Dispatchers.IO) {
                var bitmap =
                    imageApiWorker.getPictureByName("products", value.photoPath)
                picture.set(bitmap)
            }
        }
    var picture = ObservableField(
        imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background))
        private set
}