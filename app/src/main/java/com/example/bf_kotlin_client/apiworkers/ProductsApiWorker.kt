package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables

class ProductsApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun getAllByCategoryId(categoryId:Int, successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/mobile/products/getAllByCategoryId/$categoryId"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }
}