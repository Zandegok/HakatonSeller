package com.example.bf_kotlin_client.apiworkers

import android.annotation.SuppressLint
import android.provider.Settings
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ResponseApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun getAllResponses(
        successCallbackFunction: (String) -> Unit,
    ) {


        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/sellers/getAllResponses"

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
        )
    }
}