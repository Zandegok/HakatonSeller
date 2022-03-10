package com.example.bf_kotlin_client.viewmodels.products

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.products.RvAdapterProducts
import com.example.bf_kotlin_client.adapters.products.RvAdapterProductsCategories
import com.example.bf_kotlin_client.apiworkers.ProductApiWorker
import com.example.bf_kotlin_client.apiworkers.ProductCategoryApiWorker
import com.example.bf_kotlin_client.dtos.entities.ProductCategory
import com.example.bf_kotlin_client.dtos.responses.ProductsCategoriesResponse
import com.example.bf_kotlin_client.dtos.responses.ProductsResponseDto
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ProductsInCategoryViewModel {
    private var productApiWorker = ProductApiWorker()

    var category: ProductCategory = ProductCategory()
        set(value) {
            field = value
            update()
        }
    var rvProductsAdapter = ObservableField(RvAdapterProducts(arrayListOf()))
    var isRefreshing=ObservableField(false)

    init {
        update()
    }

    fun update() {
        isRefreshing.set(true)
        if (category.id>0) {
            productApiWorker.getAllByCategoryId(category.id,::updateRv)
        } else {
            productApiWorker.getAll(::updateRv)
        }
        isRefreshing.set(false)
    }

    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, ProductsResponseDto::class.java)
        rvProductsAdapter.set(RvAdapterProducts(response.products))
    }
}