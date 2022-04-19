package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.RvAdapterOffers
import com.example.bf_kotlin_client.apiworkers.OffersApiWorker
import com.example.bf_kotlin_client.dtos.responses.OffersResponse
import com.google.gson.Gson

class OffersViewModel {
    private var offersApiWorker = OffersApiWorker()

    var rvProductsAdapter = ObservableField(RvAdapterOffers(arrayListOf()))

    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, OffersResponse::class.java)

        rvProductsAdapter.set(RvAdapterOffers(response.offers))

    }
}