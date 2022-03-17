package com.example.bf_kotlin_client.adapters.farmers

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.databinding.FarmersItemPreviewBinding
import com.example.bf_kotlin_client.databinding.ProductPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Farmer
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.*

class RvAdapterFarmers(private var farmers: ArrayList<Farmer>) :
    RecyclerView.Adapter<RvAdapterFarmers.ViewHolder>() {
    private var globalVariables = GlobalVariables.instance
    private var layoutInflater = LayoutInflater.from(globalVariables.applicationContext)
    private var imageApiWorker = ImageApiWorker()
    private var fragmentManager = globalVariables.fragmentManager

    inner class ViewHolder internal constructor(var binding: FarmersItemPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background)
        )
            private set
        var farmer = Farmer()
            set(value) {
                field = value
                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("products", value.photoPath)
                    fieldImage.set(bitmap)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = FarmersItemPreviewBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = holder
        holder.farmer = farmers[position]
    }

    override fun getItemCount(): Int {
        return farmers.size
    }

}
