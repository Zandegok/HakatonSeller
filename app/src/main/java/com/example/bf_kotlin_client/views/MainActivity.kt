package com.example.bf_kotlin_client.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.utils.*
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProductsCategoriesFragment
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var globalVariables = GlobalVariables.instance

        globalVariables.fragmentManager = AppFragmentManager(supportFragmentManager)
        globalVariables.applicationContext = applicationContext
        globalVariables.httpWorker = HttpWorker(applicationContext)
        globalVariables.appDatabase = AppDatabase.getInstance(applicationContext)

        //todo check auth and reauth

        //globalVariables.androidId = Secure.getString(applicationContext.contentResolver, Secure.ANDROID_ID)

        /*GlobalScope.launch(Dispatchers.IO) {
            var value =
                GlobalVariables.instance.appDatabase.keyValuePairsRepository.getByKey("api_key")

            if (value != null) {
                globalVariables.apiKey = value
            }
        }*/

        var apiKey = "2c06052652117d40823b3614b06f965ed7df43086f5a1fe1ad2e8717ffb90e2b"
        var deviceId = "100002"

        globalVariables.httpHeaders =
            hashMapOf("API_KEY" to apiKey, "DEVICE_ID" to deviceId)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel

        globalVariables.fragmentManager.showTab(ProductsCategoriesFragment)

    }
}