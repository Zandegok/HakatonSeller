package com.example.bf_kotlin_client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.FragmentEditOfferBinding
import com.example.bf_kotlin_client.databinding.OfferPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables


class RvAdapterOffers(private var offers: ArrayList<Offer>) :
    RecyclerView.Adapter<RvAdapterOffers.ViewHolder>() {
    private var fragmentManager = GlobalVariables.instance.fragmentManager

    inner class ViewHolder internal constructor(var binding: OfferPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ViewModel {

        var offer= Offer()


        fun openEditOfferFragment() {
            fragmentManager.openFragmentAboveMain(AppFragmentManager.FragmentsName.EditOfferFragment)
            var binding = fragmentManager.getCurrentFragmentBinding<FragmentEditOfferBinding>()
            var viewModel = binding!!.viewModel!!
            viewModel.offer=offer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = OfferPreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.offer_preview, parent, false)
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.offer = offers[position]
    }

    override fun getItemCount(): Int {
        return offers.size
    }

}
