package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
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
    private var imageApiWorker = ImagesApiWorker()

    inner class ViewHolder internal constructor(var binding: ProductCategoryPreviewBinding) : RecyclerView.ViewHolder(binding.root)

    inner class ViewModel{
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            globalVariables.applicationContext.getDrawable(R.drawable.ic_launcher_background)
                ?.toBitmap()
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
            var fm = globalVariables.fragmentManager
            fm.openFragmentAboveMain(ProductsInCategoryFragment)
            var binding = fm.getCurrentFragmentBinding<FragmentProductsInCategoryBinding>()
            var viewModel = binding!!.viewModel

            viewModel!!.category = productCategory
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductCategoryPreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_category_preview, parent, false)
        )
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.productCategory = categories[position]
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}
