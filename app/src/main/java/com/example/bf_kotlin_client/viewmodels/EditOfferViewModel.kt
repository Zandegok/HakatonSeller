package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.dtos.entities.Offer

class EditOfferViewModel {
    var offer = Offer()
        set(value) {
            field = value
            productName.set(offer.productName)
            essence.set(offer.essence)
            price.set(offer.price.toString())
            isOpen.set(offer.isOpen)
        }
    var productName = ObservableField("")
    var essence = ObservableField("")
    var price = ObservableField("")
    var isOpen = ObservableField(true)

}