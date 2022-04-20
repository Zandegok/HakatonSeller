package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.RvAdapterOffers
import com.example.bf_kotlin_client.adapters.RvAdapterResponses
import com.example.bf_kotlin_client.apiworkers.ResponseApiWorker
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.dtos.entities.Response
import com.example.bf_kotlin_client.dtos.responses.ResponsesDto
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class OfferResponsesViewModel {
    private var responseApiWorker = ResponseApiWorker()
    var offer = Offer()
        set(value) {
            field = value
            responseApiWorker.getAllResponses(::updateRv)
        }
    var rvProductsAdapter = ObservableField(RvAdapterResponses(arrayListOf()))

    init {
        responseApiWorker.getAllResponses(::updateRv)
    }

    private fun updateRv(jsonData: String?) {

        var responsesDto = Gson().fromJson(jsonData, ResponsesDto::class.java)
        var buyer = GlobalVariables.instance.buyer
        var filteredResponse =
            responsesDto.responses.filter { it.requestId == offer.id } as ArrayList<Response>
        rvProductsAdapter.set(RvAdapterResponses(filteredResponse))

    }
}