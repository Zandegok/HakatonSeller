package com.example.bf_kotlin_client.viewmodels.products

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.dtos.entities.ProductCategory

class ProductsInCategoryViewModel {
    var text = ObservableField<String>("Продукты")
    var category: ProductCategory = ProductCategory()
        set(value) {
            field = value
            update()
        }

    private fun update() {
        text.set("Продукты в категории \"${category.name}\"")
    }
}