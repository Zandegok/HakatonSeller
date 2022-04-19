package com.example.bf_kotlin_client.dtos.entities

class Offer (
    var product_name:String = "",
    var essence:String = "",
    var total_price: Int? = null,
    var isOpen:Boolean = false
)