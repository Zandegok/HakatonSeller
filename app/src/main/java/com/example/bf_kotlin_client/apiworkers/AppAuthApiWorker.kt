package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class AppAuthApiWorker {
    fun auth(callbackFunction: (String) -> Unit) {
        val login = "android"
        val password = "12345"
        val deviceId = GlobalVariables.instance.androidId

        val appAuthRequest = AppAuthRequest(login, password, deviceId)

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/mobile/apps/authByLoginAndPassword"
        val request = Gson().toJson(appAuthRequest)

        val httpWorker = GlobalVariables.instance.httpWorker

        httpWorker.makeStringRequestWithBody(httpMethod, url, callbackFunction, request)
    }
}