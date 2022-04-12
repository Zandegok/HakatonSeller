package com.example.bf_kotlin_client.viewmodels.farmers

import android.graphics.Bitmap
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.dtos.entities.Farmer

class FarmerViewModel {
    private var imageApiWorker = ImagesApiWorker()

    var farmer: Farmer=Farmer()
        set(value) {
            field = value
            picture = imageApiWorker.getPictureByName("farmers", value.photoPath)
        }

    var picture: Bitmap =
        imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background)
        private set
}