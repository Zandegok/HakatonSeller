package com.example.bf_kotlin_client.viewmodels.products

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.ProductCategoryApiWorker
import com.example.bf_kotlin_client.dtos.responses.ProductsCategoriesResponse
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ProductsCategoriesViewModel {

    private var globalVariables = GlobalVariables.instance
    private var productCategoryApiWorker = ProductCategoryApiWorker()

    init {
        productCategoryApiWorker.getAll(::updateRv)
    }

    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, ProductsCategoriesResponse::class.java)

        //response.productCategories
    }
}