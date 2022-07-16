package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

/**
 * Класс, создающий и вызывающий запросы к серверу относительно преложений
 *
 */
class OffersApiWorker {
    private var globalVariables = GlobalVariables.instance

    /**
     * Вызывает запрос на список всех запросов
     *
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun getAll(successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/buyers/getAllRequests"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction
        )
    }

    /**
     * Вызывает запрос на создание нового ответа на запрос
     *
     * @param offer новый ответ на запрос
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun create(offer: Offer, successCallbackFunction: (String?) -> Unit){

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/createNewRequest"
        val request = Gson().toJson(offer)

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }

    /**
     * Вызывает запрос на изменение уже существующего ответа на запрос
     *
     * @param offer ответ на запрос с новыми параметрами и прежним id
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun update(offer: Offer, successCallbackFunction: (String?) -> Unit){

        val httpMethod = Request.Method.PUT
        val url = "http://151.248.113.116:8080/buyers/updateRequest"
        val request = Gson().toJson(offer)

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    /**
     * Вызывает запрос на удаление ответа на запрос
     *
     * @param offer выбранный ответ на запрос
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun delete(offer: Offer, successCallbackFunction: (String?) -> Unit){

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/deleteRequest"
        val request = Gson().toJson(offer)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request
        ) {
            it.message

        }
    }
}