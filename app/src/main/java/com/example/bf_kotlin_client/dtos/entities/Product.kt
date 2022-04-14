package com.example.bf_kotlin_client.dtos.entities

data class Product (
    var id: Int = 0,
    var name: String = "",
    var price: Int = 0,
    var priceMeasurementName: String = "",
    var amount: Int = 0,
    var amountMeasurementName: String = "",
    var description: String = "",
    var rating: Double = 0.0,
    var photoPath: String = "",
    var farmer: Farmer? = null,
    var productCategoryId: Int = 0,
)
{
    fun getFullPrice(): String {
        return "$price $priceMeasurementName"
    }
    fun getFullAmount():String{
        return "$amount $amountMeasurementName"
    }
    fun getRatingToString():String{
        return "$rating"
    }
}