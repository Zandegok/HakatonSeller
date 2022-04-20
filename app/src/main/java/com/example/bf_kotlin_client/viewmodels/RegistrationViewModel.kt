package com.example.bf_kotlin_client.viewmodels

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AuthApiWorker
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileAuthFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class RegistrationViewModel {
    var fragmentManager = GlobalVariables.instance.fragmentManager
    var authApiWorker = AuthApiWorker()
    var login = ObservableField("")
    var password = ObservableField("")
    var name = ObservableField("")
    var phoneNumber = ObservableField("")
    var email = ObservableField("")
    var info = ObservableField("")
    fun register() {
        var buyer = Buyer(
            name.get().toString(),
            login.get().toString(),
            password.get().toString(),
            phoneNumber.get().toString(),
            email.get().toString(),
            info.get().toString()
        ).also { it.id=-1 }
        authApiWorker.reqister(buyer,::successCallbackFunction)
    }

    private fun successCallbackFunction(data: String?) {
        if (data.equals("OK")){
            fragmentManager.showTab(ProfileAuthFragment)
        }
        else{
            Toast.makeText(GlobalVariables.instance.applicationContext,data,Toast.LENGTH_LONG).show()
        }
    }

    fun openProfileAuth() {
        fragmentManager.showTab(ProfileAuthFragment)
    }

}