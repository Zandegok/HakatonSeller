package com.example.bf_kotlin_client.viewmodels

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AuthApiWorker
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileFragment
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.RegistrationFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class ProfileAuthViewModel {
    var fragmentManager= GlobalVariables.instance.fragmentManager
    var authApiWorker= AuthApiWorker()
    var login= ObservableField("")
    var password= ObservableField("")
    fun auth(){
        authApiWorker.authByLoginAndPassword(login.get().toString(),password.get().toString(),::successCallbackFunction)
    }

    private fun successCallbackFunction(data: String?) {
        var buyer= Gson().fromJson(data,Buyer::class.java)
        if (buyer!=null)
            fragmentManager.showTab(ProfileFragment)
    }
    fun openRegistration(){
        fragmentManager.showTab(RegistrationFragment)
    }
}