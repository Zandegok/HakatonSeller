package com.example.bf_kotlin_client.viewmodels.farmers

import android.graphics.Bitmap
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.dtos.entities.Farmer
import kotlinx.coroutines.*

class FarmerViewModel {
    private var imageApiWorker = ImagesApiWorker()

    var farmer: Farmer=Farmer()
        set(value) {
            field = value
            GlobalScope.launch(Dispatchers.IO) {
                var bitmap =
                    imageApiWorker.getPictureByName("farmers", value.photoPath)
                picture.set(bitmap)
            }
        }

    var picture= ObservableField(
        imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background))
        private set
}