package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProductBinding
import com.example.bf_kotlin_client.databinding.ProductPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Product
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProductFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.*

class RvAdapterProducts(private var products: ArrayList<Product>) :
    RecyclerView.Adapter<RvAdapterProducts.ViewHolder>() {

    private var imageApiWorker = ImagesApiWorker()
    private var fragmentManager = GlobalVariables.instance.fragmentManager

    inner class ViewHolder internal constructor(var binding: ProductPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ViewModel{
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background)
        )
            private set
        var product = Product()
            set(value) {
                field = value
                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("products", value.photoPath)
                    fieldImage.set(bitmap)
                }
            }
        fun openProductView(){
            fragmentManager.openFragmentAboveMain(ProductFragment)
            var binding =
                fragmentManager.getCurrentFragmentBinding<FragmentProductBinding>()
            var viewModel = binding!!.viewModel
            viewModel!!.product=product
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductPreviewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.product_preview, parent, false))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.product = products[position]
    }

    override fun getItemCount(): Int {
        return products.size
    }

}
