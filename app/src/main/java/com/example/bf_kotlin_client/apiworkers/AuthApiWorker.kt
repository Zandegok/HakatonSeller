package com.example.bf_kotlin_client.apiworkers

import android.annotation.SuppressLint
import android.provider.Settings
import com.android.volley.Request
import com.android.volley.VolleyError
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

        var appAuthRequest = AppAuthRequest(login, password)

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/buyers/logInByLoginAndPassword"
        var request = Gson().toJson(appAuthRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun reqister(buyer: Buyer,successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/buyers/signUp"
        var request = Gson().toJson(buyer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun update(buyer: Buyer,successCallbackFunction: (String?) ->Unit){
        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/buyers/editBuyer"
        var request = Gson().toJson(buyer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )

    }
    fun getAllSellers(successCallbackFunction: (String?) -> Unit){
        var httpMethod = Request.Method.GET
        var url = "http://151.248.113.116:8080/buyers/getAllSellers"

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
        )

    }
}