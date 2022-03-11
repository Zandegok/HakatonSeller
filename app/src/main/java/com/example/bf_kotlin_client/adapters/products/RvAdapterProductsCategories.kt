package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProductsInCategoryBinding
import com.example.bf_kotlin_client.databinding.ProductCategoryPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.ProductCategory
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProductsInCategoryFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RvAdapterProductsCategories(private var categories: ArrayList<ProductCategory>) :
    RecyclerView.Adapter<RvAdapterProductsCategories.ViewHolder>() {
    private var globalVariables = GlobalVariables.instance
    private var layoutInflater = LayoutInflater.from(globalVariables.applicationContext)
    private var imageApiWorker = ImageApiWorker()
    private var fragmentManager = globalVariables.fragmentManager

    inner class ViewHolder internal constructor(var binding: ProductCategoryPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            imageApiWorker.getSystemBitmapFromDrawableId(R.drawable.ic_launcher_background)
        )
            private set
        var productCategory = ProductCategory()
            set(value) {
                field = value
                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("productsCategories", value.pictureName)
                    fieldImage.set(bitmap)
                }
            }
        fun openProductList() {
            fragmentManager.openFragmentAboveMain(ProductsInCategoryFragment)
            var binding =
                fragmentManager.getCurrentFragmentBinding<FragmentProductsInCategoryBinding>()
            var viewModel = binding!!.viewModel
            viewModel!!.category = productCategory
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductCategoryPreviewBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = holder
        holder.productCategory = categories[position]
    }
    override fun getItemCount(): Int {
        return categories.size
    }
}
