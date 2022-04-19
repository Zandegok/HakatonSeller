package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class OffersApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun getAll(successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/buyers/getAll"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }

    fun create(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/buyers/createNewRequest"
        var request = Gson().toJson(offer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
}