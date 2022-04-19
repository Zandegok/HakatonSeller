package com.example.bf_kotlin_client.apiworkers

import android.annotation.SuppressLint
import android.provider.Settings
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class RequestApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun getAllRequests(
        successCallbackFunction: (String) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {


        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/sellers/getAllRequests"

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            hashMapOf(),
            errorCallbackFunction
        )
    }
    fun createNewRequest(request: com.example.bf_kotlin_client.dtos.entities.Request,
        successCallbackFunction: (String?) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {
        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/sellers/createNewRequest"
        var request = Gson().toJson(request)
        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            hashMapOf(),
            errorCallbackFunction
        )
    }
}