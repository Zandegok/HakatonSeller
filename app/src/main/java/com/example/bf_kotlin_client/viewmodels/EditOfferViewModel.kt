package com.example.bf_kotlin_client.viewmodels

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.OffersApiWorker
import com.example.bf_kotlin_client.databinding.FragmentOfferResponsesBinding
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.OfferResponses
import com.example.bf_kotlin_client.utils.GlobalVariables

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
    var offersApiWorker = OffersApiWorker()
    fun update() {
        var newOffer = Offer(offer.id, productName.get().toString(), essence.get().toString(),
            ((price.get().toString().toDouble()) * 100).toInt(), isOpen.get()!!, offer.buyerId)
        offersApiWorker.update(newOffer
        ) {
            if (it.equals("OK")) {
                offer=newOffer
            }
            Toast.makeText(GlobalVariables.instance.applicationContext, it, Toast.LENGTH_LONG)
                .show()
        }
    }

    fun delete() {
        offersApiWorker.delete(offer){
            Toast.makeText(GlobalVariables.instance.applicationContext, it, Toast.LENGTH_LONG)
                .show()
        }
    }
    fun openResponsesFragment(){
        var fragmentManager = GlobalVariables.instance.fragmentManager
        fragmentManager.openFragmentAboveMain(OfferResponses)
        var binding=fragmentManager.getCurrentFragmentBinding<FragmentOfferResponsesBinding>()!!
        var viewModel = binding.viewModel!!
        viewModel.offer=offer
    }
}