package com.example.bf_kotlin_client.dtos.entities

data class Farmer(
    var id: Int = 0,
    var firstName: String="",
    var lastName: String="",
    var email: String="",
    var phoneNumber: String="",
    var photoPath: String="",
    var description: String="",
    var farmerDeliveryTypeName: String="",
    var pickupAddress: String="",
    var latLng: String="",
){
    fun getFullName() = "$firstName $lastName"
}