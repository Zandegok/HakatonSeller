package com.example.bf_kotlin_client.viewmodels.products

import android.graphics.Bitmap
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.dtos.entities.Product

class ProductViewModel {
    private var imageApiWorker = ImageApiWorker()
    var product: Product = Product()
        set(value) {
            field = value
            picture = imageApiWorker.getPictureByName("products", value.photoPath)
        }
    var picture: Bitmap =
        imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background)
        private set
}