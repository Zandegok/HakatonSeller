package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.databinding.ProductPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Product
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RvAdapterProducts(private var products: ArrayList<Product>) :
    RecyclerView.Adapter<RvAdapterProducts.ViewHolder>() {

    inner class ViewHolder internal constructor(var binding: ProductPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var globalVariables = GlobalVariables.instance
        private var imageApiWorker = ImageApiWorker()
        var fieldTitle: ObservableField<String> = ObservableField("")
            private set
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            imageApiWorker.getSystemBitmapFromDrawableId(R.drawable.ic_launcher_background)
        )
            private set

        var product = Product()
            set(value) {
                field = value
                fieldTitle.set(value.name)
                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("products", value.photoPath)
                    fieldImage.set(bitmap)
                }
            }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductPreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_preview, parent, false)
        )
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = holder

        holder.product = products[position]

    }

    override fun getItemCount(): Int {
        return products.size
    }

}
