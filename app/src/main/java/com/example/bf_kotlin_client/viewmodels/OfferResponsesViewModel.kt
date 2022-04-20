package com.example.bf_kotlin_client.viewmodels

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.RvAdapterOffers
import com.example.bf_kotlin_client.apiworkers.OffersApiWorker
import com.example.bf_kotlin_client.apiworkers.ResponseApiWorker
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.dtos.responses.OffersResponse
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class OfferResponsesViewModel {
    private var responsesApiWorker = ResponseApiWorker()

    var rvProductsAdapter = ObservableField(RvAdapterOffers(arrayListOf()))
    init{
        responsesApiWorker.getAllResponses ( ::updateRv , ::error)
    }
    private fun updateRv(jsonData: String?) {

        var response = Gson().fromJson(jsonData, OffersResponse::class.java)
        var buyer= GlobalVariables.instance.buyer
        var filteredResponse=response.requests.filter { it.buyerId == buyer.id } as ArrayList<Offer>
        rvProductsAdapter.set(RvAdapterOffers(filteredResponse))

    }

    private fun error(){
        Toast.makeText(GlobalVariables.instance.applicationContext,"error",Toast
            .LENGTH_LONG).show()
    }

}