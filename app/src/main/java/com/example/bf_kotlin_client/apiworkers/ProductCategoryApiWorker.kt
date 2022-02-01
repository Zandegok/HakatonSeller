package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.models.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ProductCategoryApiWorker {
    fun getAll(callbackFunction: (String) -> Unit, apiKey: String, deviceId: String) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/mobile/productsCategories/getAll"
        val httpWorker = GlobalVariables.instance.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            callbackFunction,
            mutableMapOf("API_KEY" to apiKey, "DEVICE_ID" to deviceId)
        )
    }
}