package com.example.bf_kotlin_client.apiworkers

import android.provider.Settings
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.dtos.requests.ClientRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ClientsApiWorker {
    private var globalVariables = GlobalVariables.instance

    fun authByEmailAndPassword(
        email: String,
        password: String,
        successCallbackFunction: (String) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {

        var clientRequest = ClientRequest(email, password)

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/mobile/clients/authByEmailAndPassword"
        var request = Gson().toJson(clientRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
            globalVariables.httpHeaders,
            errorCallbackFunction
        )
    }
}