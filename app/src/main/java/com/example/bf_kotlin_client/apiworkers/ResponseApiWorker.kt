package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables

class ResponseApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun getAllResponses(
        successCallbackFunction: (String) -> Unit,
    ) {
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/sellers/getAllResponses"
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
        )
    }
}