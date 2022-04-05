package com.example.bf_kotlin_client.apiworkers

import android.annotation.SuppressLint
import android.provider.Settings
import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class AppAuthApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun authByLoginAndPassword(successCallbackFunction: (String) -> Unit) {
        var login = "android"
        var password = "12345"
        var deviceId = Settings.Secure.getString(GlobalVariables.instance.applicationContext.contentResolver, Settings.Secure.ANDROID_ID)

        var appAuthRequest = AppAuthRequest(login, password, deviceId)

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/mobile/apps/authByLoginAndPassword"
        var request = Gson().toJson(appAuthRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(httpMethod, url, successCallbackFunction, request)
    }
}