package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class OffersApiWorker {
    private var globalVariables = GlobalVariables.instance
    fun getAll(successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/buyers/getAllRequests"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction
        )
    }
    fun create(offer: Offer, successCallbackFunction: (String?) -> Unit){

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/createNewRequest"
        val request = Gson().toJson(offer)

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun update(offer: Offer, successCallbackFunction: (String?) -> Unit){

        val httpMethod = Request.Method.PUT
        val url = "http://151.248.113.116:8080/buyers/updateRequest"
        val request = Gson().toJson(offer)

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun delete(offer: Offer, successCallbackFunction: (String?) -> Unit){

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/deleteRequest"
        val request = Gson().toJson(offer)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request
        ) {
            it.message

        }
    }
}