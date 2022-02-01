package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AppAuthApiWorker
import com.example.bf_kotlin_client.apiworkers.ProductCategoryApiWorker
import com.example.bf_kotlin_client.models.AppAuthResponse
import com.example.bf_kotlin_client.models.ProductsCategoriesResponse
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class MainActivityViewModel {
    private val appAuthApiWorker = AppAuthApiWorker()
    private val productCategoryApiWorker = ProductCategoryApiWorker()

    val fieldApiKey: ObservableField<String> = ObservableField("data....")
    val fieldProductsCategories: ObservableField<String> = ObservableField("data....")

    private fun updateFieldApiKey(data: String) {
        val appAuthResponse = Gson().fromJson(data, AppAuthResponse::class.java)
        GlobalVariables.instance.apiKey = appAuthResponse.apiKey
        fieldApiKey.set(appAuthResponse.apiKey)
    }

    private fun updateFieldCategories(data: String) {
        val response = Gson().fromJson(data, ProductsCategoriesResponse::class.java)
        fieldProductsCategories.set(response.productCategories[0].name)
    }

    fun authorize() {
        appAuthApiWorker.auth(::updateFieldApiKey)
    }

    fun getAllCategories() {
        productCategoryApiWorker.getAll(
            ::updateFieldCategories,
            "f9f195057e841496f6ba4bb0234224d1917f7efb73295eb79585857f080c17e4",
            "2sdfssdf3"
        )
    }

}