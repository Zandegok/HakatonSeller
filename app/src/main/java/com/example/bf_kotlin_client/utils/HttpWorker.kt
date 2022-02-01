package com.example.bf_kotlin_client.utils

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.nio.charset.Charset

class HttpWorker(private val applicationContext: Context) {
    private val volleyQueue = Volley.newRequestQueue(applicationContext)

    private fun errorFunction(volleyError: VolleyError) {
        Toast.makeText(applicationContext, volleyError.toString(), Toast.LENGTH_LONG).show()
    }

    fun makeStringRequestWithoutBody(
        httpMethod: Int,
        url: String,
        callbackFunction: (String) -> Unit,
        httpHeaders: MutableMap<String, String> = hashMapOf()
    ) {
        val request = object : StringRequest(
            httpMethod,
            url,
            callbackFunction,
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