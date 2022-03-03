package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class AppAuthApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun authByLoginAndPassword(successCallbackFunction: (String) -> Unit) {
        val login = "android"
        val password = "12345"
        val deviceId = globalVariables.deviceId

        val appAuthRequest = AppAuthRequest(login, password, deviceId)

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/mobile/apps/authByLoginAndPassword"
        val request = Gson().toJson(appAuthRequest)

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(httpMethod, url, successCallbackFunction, request)
    }
}