package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

/**
 * Класс, создающий и вызывающий запросы к серверу отностельно пользователей
 *
 */
class AuthApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * Вызывает запрос на аутентификацию пользователя по указанному логину и паролю
     *
     * @param login логин покупателя
     * @param password пароль покупателя
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun authByLoginAndPassword(
        login: String,
        password: String,
        successCallbackFunction: (String?) -> Unit,
    ) {
        val appAuthRequest = AppAuthRequest(login, password)
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/logInByLoginAndPassword"
        val request = Gson().toJson(appAuthRequest)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }

    /**
     * Вызывает запрос на регистрацию пользователя
     *
     * @param buyer новый пользователь
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun register(buyer: Buyer, successCallbackFunction: (String?) -> Unit){
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/signUp"
        val request = Gson().toJson(buyer)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }

    /**
     * Вызывает запрос на измение пользователя по указанному логину и паролю
     *
     * @param buyer пользователь, данные которого изменяются (логин изменить нельзя)
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun update(buyer: Buyer,successCallbackFunction: (String?) ->Unit){
        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/buyers/editBuyer"
        val request = Gson().toJson(buyer)
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )

    }

    /**
     * Выдаёт список всех продавцов
     *
     * @param successCallbackFunction функция, обрабатывающая ответ в случае успешного запроса
     */
    fun getAllSellers(successCallbackFunction: (String?) -> Unit){
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/buyers/getAllSellers"
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
        )
    }
}