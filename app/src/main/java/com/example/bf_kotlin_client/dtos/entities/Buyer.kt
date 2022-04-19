package com.example.bf_kotlin_client.dtos.entities

data class Buyer(
    var name: String = "",
    var login: String = "",
    var password: String = "",
    var phoneNumber: String? = null,
    var email: String? = null,
    var info: Any,
) {

    var id = 0

}