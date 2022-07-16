package com.example.bf_kotlin_client.viewmodels

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.AuthApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.localdb.models.KeyValuePair
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileFragment
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.RegistrationFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson
import kotlinx.coroutines.*

class ProfileAuthViewModel {

    var authApiWorker = AuthApiWorker()
    var login = ObservableField("")
    var password = ObservableField("")

    init {
        var keyValuePairsRepository = GlobalVariables.instance.appDatabase.keyValuePairsRepository
        var login: String?
        var password: String?
        GlobalScope.launch(Dispatchers.IO) {
            login = keyValuePairsRepository.getByKey("login")
            password = keyValuePairsRepository.getByKey("password")
            setLoginAndPassword(login, password)
        }
    }

    private fun setLoginAndPassword(login: String?, password: String?) {
        if (login != null && password != null) {
            this.login.set(login)
            this.password.set(password)
        }
    }

    fun auth() {
        authApiWorker.authByLoginAndPassword(login.get().toString(),
            password.get().toString(),
            ::successCallbackFunction)
    }

    private fun successCallbackFunction(data: String?) {
        val buyer = Gson().fromJson(data, Buyer::class.java)
        if (buyer == null) {
            Toast.makeText(GlobalVariables.instance.applicationContext,
                "Не удалось найти указанного пользователя",
                Toast.LENGTH_LONG).show()
            return
        }
        val fragmentManager = GlobalVariables.instance.fragmentManager
        fragmentManager.showTab(ProfileFragment)
        val binding = fragmentManager.getCurrentFragmentBinding<FragmentProfileBinding>()!!
        val viewModel = binding.viewModel!!
        viewModel.buyer = buyer
        GlobalVariables.instance.buyer = buyer
        GlobalVariables.instance.mainActivityViewModel.bottomNavigationViewEnabled = true;
        val keyValuePairsRepository = GlobalVariables.instance.appDatabase.keyValuePairsRepository
        GlobalScope.launch(Dispatchers.IO) {
            keyValuePairsRepository.insert(KeyValuePair("login", login.get().toString()))
            keyValuePairsRepository.insert(KeyValuePair("password", password.get().toString()))
        }
    }

    fun openRegistration() {
        val fragmentManager = GlobalVariables.instance.fragmentManager
        fragmentManager.showTab(RegistrationFragment)
    }
}