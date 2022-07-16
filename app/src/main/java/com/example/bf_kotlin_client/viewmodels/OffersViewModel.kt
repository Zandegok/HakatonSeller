package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.RvAdapterOffers
import com.example.bf_kotlin_client.apiworkers.OffersApiWorker
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.dtos.responses.OffersResponse
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class OffersViewModel {
    private var offersApiWorker = OffersApiWorker()

    var rvProductsAdapter = ObservableField(RvAdapterOffers(arrayListOf()))

    init {
        offersApiWorker.getAll(::updateRv)

    }

    private fun updateRv(jsonData: String?) {

        val response = Gson().fromJson(jsonData, OffersResponse::class.java)
        val buyer = GlobalVariables.instance.buyer
        val filteredResponse =
            response.requests.filter { it.buyerId == buyer.id } as ArrayList<Offer>
        rvProductsAdapter.set(RvAdapterOffers(filteredResponse))

    }
}