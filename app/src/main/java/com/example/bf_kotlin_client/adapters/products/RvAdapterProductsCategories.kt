package com.example.bf_kotlin_client.adapters.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.ProductCategoryPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.ProductCategory

class RvAdapterProductsCategories(private var categories: ArrayList<ProductCategory>) :
    RecyclerView.Adapter<RvAdapterProductsCategories.ViewHolder>() {

    inner class ViewHolder internal constructor(var binding: ProductCategoryPreviewBinding) : RecyclerView.ViewHolder(binding.root) {
        var fieldTitle = ObservableField("")

        fun someFun() {

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
        holder.binding.viewModel = holder

        holder.fieldTitle.set(categories[position].name);
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}
