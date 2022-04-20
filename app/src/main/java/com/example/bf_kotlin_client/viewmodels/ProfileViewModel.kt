package com.example.bf_kotlin_client.viewmodels

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AuthApiWorker
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.utils.GlobalVariables

class ProfileViewModel {
    var fragmentManager = GlobalVariables.instance.fragmentManager
    var authApiWorker = AuthApiWorker()
    var login = ObservableField("")
    var password = ObservableField("")
    var name = ObservableField("")
    var phoneNumber = ObservableField("")
    var email = ObservableField("")
    var info = ObservableField("")
    var buyer = Buyer()
        set(value) {
            field = value
            login.set(value.login)
            password.set(value.password)
            name.set(value.name)
            phoneNumber.set(value.phoneNumber)
            email.set(value.email)
            info.set(value.info)
        }

    fun update() {
        var newBuyer = Buyer(name.get().toString(),
            login.get().toString(),
            password.get().toString(),
            phoneNumber.get().toString(),
            email.get().toString(),
            info.get().toString()).also { it.id=buyer.id }
        authApiWorker.update(newBuyer){ Toast.makeText(GlobalVariables.instance.applicationContext,it,Toast.LENGTH_LONG).show()}
    }

}