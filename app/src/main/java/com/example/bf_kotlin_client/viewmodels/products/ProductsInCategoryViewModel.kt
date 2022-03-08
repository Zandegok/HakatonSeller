package com.example.bf_kotlin_client.viewmodels.products

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.dtos.entities.ProductCategory

class ProductsInCategoryViewModel {
    var category= ObservableField<ProductCategory>()
    var text=ObservableField<String>("Продукты")
    init {
        category.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                update()
            }
        })
    }

    private fun update() {
        text.set("Продукты в категории \"${category.get()!!.name}\"")
    }
}