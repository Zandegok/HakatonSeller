package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables

class ProductCategoryApiWorker {
    fun getAll(callbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/mobile/productsCategories/getAll"
        val apiKey = GlobalVariables.instance.apiKey
        val deviceId = GlobalVariables.instance.androidId
        val httpWorker = GlobalVariables.instance.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            callbackFunction,
            mutableMapOf("API_KEY" to apiKey, "DEVICE_ID" to deviceId)
        )
    }
}