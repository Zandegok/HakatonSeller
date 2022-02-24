package com.example.bf_kotlin_client.utils

import android.content.Context
import android.widget.Toast
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bf_kotlin_client.dtos.entities.ServerError
import com.google.gson.Gson

class HttpWorker(private val applicationContext: Context) {
    private val volleyQueue = Volley.newRequestQueue(applicationContext)

    private fun errorFunction(volleyError: VolleyError) {

        var httpCode = volleyError.networkResponse.statusCode
        var dataInJson = volleyError.networkResponse.data.toString(Charsets.UTF_8)

        var data = Gson().fromJson(dataInJson, ServerError::class.java)

        var errorMessage = "$httpCode: ${data.message}";

        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
    }

    fun makeStringRequestWithoutBody(
        httpMethod: Int,
        url: String,
        successCallbackFunction: (String) -> Unit,
        httpHeaders: MutableMap<String, String> = hashMapOf()
    ) {
        val request = object : StringRequest(
            httpMethod,
            url,
            successCallbackFunction,
            ::errorFunction
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return httpHeaders;
            }
        }

        volleyQueue.add(request)
    }

    fun makeStringRequestWithBody(
        httpMethod: Int,
        url: String,
        callbackFunction: (String) -> Unit,
        request: String,
        httpHeaders: MutableMap<String, String> = hashMapOf()
    ) {
        val request = object : StringRequest(
            httpMethod,
            url,
            callbackFunction,
            ::errorFunction
        ) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return request.toByteArray()
            }

            override fun getHeaders(): MutableMap<String, String> {
                return httpHeaders;
            }
        }

        volleyQueue.add(request)
    }
}