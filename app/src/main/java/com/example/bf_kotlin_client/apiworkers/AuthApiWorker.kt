package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class AuthApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun authByLoginAndPassword(
        login: String,
        password: String,
        successCallbackFunction: (String?) -> Unit,
    ) {
        val appAuthRequest = AppAuthRequest(login, password)
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/logInByLoginAndPassword"
        val request = Gson().toJson(appAuthRequest)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun register(buyer: Buyer, successCallbackFunction: (String?) -> Unit){
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/signUp"
        val request = Gson().toJson(buyer)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun update(buyer: Buyer,successCallbackFunction: (String?) ->Unit){
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/editBuyer"
        val request = Gson().toJson(buyer)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )

    }
    fun getAllSellers(successCallbackFunction: (String?) -> Unit){
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/buyers/getAllSellers"
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
        )
    }
}