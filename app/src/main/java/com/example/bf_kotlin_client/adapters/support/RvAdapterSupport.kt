package com.example.bf_kotlin_client.adapters.support

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.adapters.products.RvAdapterProducts
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProductsInCategoryBinding
import com.example.bf_kotlin_client.databinding.ProductCategoryPreviewBinding
import com.example.bf_kotlin_client.databinding.ProductPreviewBinding
import com.example.bf_kotlin_client.databinding.SupportPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Faq
import com.example.bf_kotlin_client.utils.GlobalVariables
import java.util.ArrayList

class RvAdapterSupport(private var faqs: ArrayList<Faq>):
    RecyclerView.Adapter<RvAdapterSupport.ViewHolder>()  {

    inner class ViewHolder internal constructor(var binding: SupportPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var globalVariables = GlobalVariables.instance

        var faq = Faq()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapterSupport.ViewHolder {
        var binding = SupportPreviewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.support_preview, parent, false))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvAdapterSupport.ViewHolder, position: Int) {
        holder.binding.viewModel = holder
        holder.faq = faqs[position]
    }

    override fun getItemCount(): Int {
        return faqs.size
    }

}