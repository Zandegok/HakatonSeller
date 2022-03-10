package com.example.bf_kotlin_client.dtos.entities

class Farmer(
    var id: Int = 0,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var photoPath: String? = null,
    var description: String? = null,
    var farmerDeliveryTypeName: String? = null,
    var pickupAddress: String? = null,
    var latLng: String? = null,
)