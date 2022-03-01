package com.example.bf_kotlin_client.viewmodels.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.ProductCategoryPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.ProductCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RvAdapterProductsCategories(var categories: ArrayList<ProductCategory>) :
    RecyclerView.Adapter<RvAdapterProductsCategories.ViewHolder>() {
    inner class ViewHolder internal constructor(val binding: ProductCategoryPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val fieldTitle = ObservableField("")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ProductCategoryPreviewBinding.bind(LayoutInflater.from(parent.context)
            .inflate(R.layout.product_category_preview, parent, false))
        return ViewHolder(v)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder)
        {
            binding.viewModel = holder
            with(categories[position]) {
                fieldTitle.set(name)
            }
        }
    }

    override fun getItemCount()=categories.size

}
