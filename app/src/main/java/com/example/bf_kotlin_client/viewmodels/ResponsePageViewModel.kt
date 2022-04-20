package com.example.bf_kotlin_client.viewmodels

import com.example.bf_kotlin_client.apiworkers.AuthApiWorker
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.entities.Response
import com.example.bf_kotlin_client.dtos.responses.SellersResponse
import com.google.gson.Gson

class ResponsePageViewModel {
    var authApiWorker = AuthApiWorker()
    var seller = Buyer()
    var response = Response()
        set(value) {
            field = value
            authApiWorker.getAllSellers {
                var sellersResponse = Gson().fromJson(it, SellersResponse::class.java)
                seller = sellersResponse.seller.first { it.id == value.sellerId}
            }
        }

}