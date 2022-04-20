package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AuthApiWorker
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.entities.Response
import com.example.bf_kotlin_client.dtos.responses.SellersResponse
import com.google.gson.Gson

class ResponsePageViewModel {
    var authApiWorker = AuthApiWorker()
    var phone = ObservableField("")
    var price = ObservableField("")
    var name = ObservableField("")
    var comment = ObservableField("")
    var seller = Buyer()
    var response = Response()
        set(value) {
            field = value
            authApiWorker.getAllSellers {
                var sellersResponse = Gson().fromJson(it, SellersResponse::class.java)
                seller = sellersResponse.seller.first { it.id == value.sellerId}
            }
            name.set(seller.name)
            phone.set(seller.phoneNumber)
            comment.set(response.comment)
            price.set(response.price.toString())
        }



}