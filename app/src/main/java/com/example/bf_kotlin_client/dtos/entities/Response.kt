package com.example.bf_kotlin_client.dtos.entities

class Response(
    var id: Int = 0, var price: Int = 0, var comment: String="",
    var requestId: Int = 0, var sellerId: Int = 0,
)
{
    fun getPriceString(): String {return price.toString()}
}