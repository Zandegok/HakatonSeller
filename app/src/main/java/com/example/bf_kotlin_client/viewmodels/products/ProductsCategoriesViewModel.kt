package com.example.bf_kotlin_client.viewmodels.products

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.products.RvAdapterProductsCategories
import com.example.bf_kotlin_client.apiworkers.ProductCategoryApiWorker
import com.example.bf_kotlin_client.dtos.responses.ProductsCategoriesResponse
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ProductsCategoriesViewModel {
    private var productCategoryApiWorker = ProductCategoryApiWorker()

    var rvProductsAdapter = ObservableField(RvAdapterProductsCategories(arrayListOf()))
    var isRefreshing=ObservableField(false)

    init {
        update()
    }

    fun update() {
        isRefreshing.set(true)
        productCategoryApiWorker.getAll(::updateRv)
        isRefreshing.set(false)
    }

    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, ProductsCategoriesResponse::class.java)

        rvProductsAdapter.set(RvAdapterProductsCategories(response.productCategories))

    }
}