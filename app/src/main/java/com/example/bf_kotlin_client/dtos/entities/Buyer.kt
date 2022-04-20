package com.example.bf_kotlin_client.dtos.entities

data class Buyer(
    var name: String = "",
    var login: String = "",
    var password: String = "",
    var phoneNumber: String="",
    var email: String="",
    var info: String ="",
) {
    var id = 0
}