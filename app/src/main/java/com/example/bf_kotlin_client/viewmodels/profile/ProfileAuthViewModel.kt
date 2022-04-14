package com.example.bf_kotlin_client.viewmodels.profile

import androidx.appcompat.app.AlertDialog
import androidx.databinding.ObservableField
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.apiworkers.ClientsApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProductsInCategoryBinding
import com.example.bf_kotlin_client.databinding.FragmentProfileAuthBinding
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.dtos.entities.ServerError
import com.example.bf_kotlin_client.dtos.responses.ClientResponse
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ProfileAuthViewModel {
    private var clientsApiWorker = ClientsApiWorker()
    private var globalVariables = GlobalVariables.instance

    var emailField = ObservableField("")
    var passwordField = ObservableField("")

    fun auth() {
        var email = emailField.get().toString()
        var password = passwordField.get().toString()

        clientsApiWorker.authByEmailAndPassword(email, password, ::authSuccess, ::authError)
    }

    private fun authSuccess(data: String) {
        var response = Gson().fromJson(data,ClientResponse::class.java)

        var fm = globalVariables.fragmentManager
        fm.openFragmentAboveMain(AppFragmentManager.FragmentsName.ProfileFragment)

        var binding = fm.getCurrentFragmentBinding<FragmentProfileBinding>()!!
        var viewModel = binding.viewModel!!

        viewModel.client = response;
    }

    private fun authError(volleyError: VolleyError) {
        if (volleyError.networkResponse == null) {
            var builder = AlertDialog.Builder(globalVariables.applicationContext)
            builder.setMessage("Сервер недоступен, повторите запрос позже")
            builder.setTitle("Ошибка:")
            builder.setPositiveButton("OK", null)
            builder.setCancelable(true)
            builder.create().show()
            return
        }

        var httpCode = volleyError.networkResponse.statusCode
        var dataInJson = volleyError.networkResponse.data.toString(Charsets.UTF_8)
        var data = Gson().fromJson(dataInJson, ServerError::class.java)
        var errorMessage = "$httpCode: ${data.message}"

        var builder = AlertDialog.Builder(globalVariables.applicationContext)
        builder.setMessage("$errorMessage, попробуйте ввести другую пару логин и пароль")
        builder.setTitle("Ошибка сервера:")
        builder.setPositiveButton("OK", null)
        builder.setCancelable(true)
        builder.create().show()
    }
}