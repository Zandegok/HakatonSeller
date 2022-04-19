package com.example.bf_kotlin_client.apiworkers

import android.annotation.SuppressLint
import android.provider.Settings
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class BuyerApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun authByLoginAndPassword(
        login: String,
        password: String,
        successCallbackFunction: (String?) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {

        var appAuthRequest = AppAuthRequest(login, password)

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/sellers/logInByLoginAndPassword"
        var request = Gson().toJson(appAuthRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
            hashMapOf(),
            errorCallbackFunction
        )
    }
}