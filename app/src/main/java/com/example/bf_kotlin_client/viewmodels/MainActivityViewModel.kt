package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AppAuthApiWorker
import com.example.bf_kotlin_client.models.AppAuthResponse
import com.google.gson.Gson

class MainActivityViewModel {
    private val appAuthApiWorker = AppAuthApiWorker()

    val fieldApiKey: ObservableField<String> = ObservableField("data....")

    private fun updateFieldApiKey(data: String) {
        val appAuthResponse = Gson().fromJson(data, AppAuthResponse::class.java)

        fieldApiKey.set(appAuthResponse.apiKey)
    }

    fun authorize() {
        appAuthApiWorker.auth(::updateFieldApiKey)
    }
}