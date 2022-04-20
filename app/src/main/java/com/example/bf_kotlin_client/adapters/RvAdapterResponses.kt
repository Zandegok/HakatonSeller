package com.example.bf_kotlin_client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.FragmentEditOfferBinding
import com.example.bf_kotlin_client.databinding.FragmentResponsePageBinding
import com.example.bf_kotlin_client.databinding.OfferPreviewBinding
import com.example.bf_kotlin_client.databinding.OfferResponcePreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.dtos.entities.Response
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables

class RvAdapterResponses (private var responces: ArrayList<Response>):
    RecyclerView.Adapter<RvAdapterResponses.ViewHolder>() {
        private var fragmentManager = GlobalVariables.instance.fragmentManager

        inner class ViewHolder internal constructor(var binding: OfferResponcePreviewBinding) :
            RecyclerView.ViewHolder(binding.root)

        inner class ViewModel {

            var response= Response()


            fun openResponseFragment() {
                fragmentManager.openFragmentAboveMain(AppFragmentManager.FragmentsName.ResponsePage)
                var binding = fragmentManager.getCurrentFragmentBinding<FragmentResponsePageBinding>()
                var viewModel = binding!!.viewModel!!
                viewModel.response=response
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var binding = OfferResponcePreviewBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.offer_responce_preview, parent, false)
            )

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.viewModel = ViewModel()
            holder.binding.viewModel!!.response = responces[position]
        }

        override fun getItemCount(): Int {
            return responces.size
        }
    }

