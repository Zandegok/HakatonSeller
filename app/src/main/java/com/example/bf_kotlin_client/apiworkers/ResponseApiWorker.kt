package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * Класс, создающий и вызывающий запросы к серверу отностельно запросов
 *
 */
class ResponseApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * выдаёт список всех запросов
     *
     * @param successCallbackFunction
     */
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