package com.example.bf_kotlin_client.viewmodels

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables

class CreateOfferViewModel {
    var fragmentManager= GlobalVariables.instance.fragmentManager
    var offersApiWorker = com.example.bf_kotlin_client.apiworkers.OffersApiWorker()
    var price = ObservableField("")
    var description = ObservableField("")
    var name = ObservableField("")
    fun create() {
        var offer = Offer(0,
            name.get().toString(),
            description.get().toString(),
            (price.get()!!.toDouble() * 100).toInt(),
            true,GlobalVariables.instance.buyer.id
        )
        offersApiWorker.create(offer,::successCallbackFunction)
    }

    private fun successCallbackFunction(data: String?) {
        if (data.equals("OK")){
            fragmentManager.showTab(AppFragmentManager.FragmentsName.OffersFragment)
            Toast.makeText(GlobalVariables.instance.applicationContext,"success",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(GlobalVariables.instance.applicationContext,data, Toast.LENGTH_LONG).show()
        }
    }
}