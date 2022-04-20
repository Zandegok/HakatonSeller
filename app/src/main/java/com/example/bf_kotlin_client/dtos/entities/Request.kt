package com.example.bf_kotlin_client.dtos.entities

class Request(
    var id: Int = 0,
    var productName: String = "",
    var essence: String = "",
    var totalPrice: Int = 0,
    var isOpen: Boolean = true,
    var buyerId: Int = 0,
) {
    var price
        get() = totalPrice / 100.0
        set(value) {
            totalPrice = (value * 100).toInt()
        }
}