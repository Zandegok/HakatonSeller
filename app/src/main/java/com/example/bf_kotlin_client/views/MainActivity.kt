package com.example.bf_kotlin_client.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.example.bf_kotlin_client.utils.HttpWorker
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel
import android.provider.Settings.Secure
import com.example.bf_kotlin_client.utils.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val globalVariables = GlobalVariables.instance

        globalVariables.applicationContext = applicationContext
        globalVariables.httpWorker = HttpWorker(applicationContext)
        globalVariables.androidId =
            Secure.getString(applicationContext.contentResolver, Secure.ANDROID_ID)
        globalVariables.appDatabase = AppDatabase.getInstance(applicationContext)

        GlobalScope.launch(Dispatchers.IO) {
            var value =
                GlobalVariables.instance.appDatabase.keyValuePairsRepository.getByKey("api_key")

            if (value != null) {
                globalVariables.apiKey = value
            }
        }


        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel
    }
}