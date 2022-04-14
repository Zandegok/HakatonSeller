package com.example.bf_kotlin_client.views

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.apiworkers.AppAuthApiWorker
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.dtos.entities.ServerError
import com.example.bf_kotlin_client.dtos.responses.AppAuthResponse
import com.example.bf_kotlin_client.utils.*
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProductsCategoriesFragment
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel
import com.google.gson.Gson
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private var globalVariables = GlobalVariables.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        globalVariables.applicationContext = this
        globalVariables.httpWorker = HttpWorker(this)
        globalVariables.layoutInflater= LayoutInflater.from(this)

        //globalVariables.appDatabase = AppDatabase.getInstance(applicationContext)

        var appAuthApiWorker = AppAuthApiWorker()

        var login = "android"
        var password = "12345"
        var deviceId = Settings.Secure.getString(
            GlobalVariables.instance.applicationContext.contentResolver,
            Settings.Secure.ANDROID_ID
        )

        appAuthApiWorker.authByLoginAndPassword(
            login,
            password,
            deviceId,
            ::initializeComponents,
            ::processError
        )
    }

    private fun initializeComponents(data: String) {
        var response = Gson().fromJson(data, AppAuthResponse::class.java)

        globalVariables.httpHeaders = hashMapOf(
            "API_KEY" to response.apiKey,
            "DEVICE_ID" to Settings.Secure.getString(
                GlobalVariables.instance.applicationContext.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        )

        globalVariables.fragmentManager = AppFragmentManager(supportFragmentManager)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel

        globalVariables.fragmentManager.showTab(ProductsCategoriesFragment)
    }

    private fun processError(volleyError: VolleyError) {
        if (volleyError.networkResponse == null) {
            var builder = AlertDialog.Builder(this)
            builder.setMessage("Сервер недоступен, приложение будет закрыто")
            builder.setTitle("Ошибка:")
            builder.setPositiveButton("OK") {_,_-> finishAffinity() }
            builder.setCancelable(true)
            builder.create().show()
            return
        }

        var httpCode = volleyError.networkResponse.statusCode
        var dataInJson = volleyError.networkResponse.data.toString(Charsets.UTF_8)
        var data = Gson().fromJson(dataInJson, ServerError::class.java)
        var errorMessage = "$httpCode: ${data.message}"

        var builder = AlertDialog.Builder(this)
        builder.setMessage("$errorMessage, приложение будет закрыто")
        builder.setTitle("Ошибка сервера:")
        builder.setPositiveButton("OK") {_,_-> finishAffinity() }
        builder.setCancelable(true)
        builder.create().show()
    }
}