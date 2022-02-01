package com.example.bf_kotlin_client.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.example.bf_kotlin_client.utils.HttpWorker
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel
import android.provider.Settings.Secure
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val android_id = Secure.getString(
            applicationContext.contentResolver,
            Secure.ANDROID_ID
        )

        val globalVariables = GlobalVariables.instance

        globalVariables.applicationContext = applicationContext
        globalVariables.httpWorker = HttpWorker(applicationContext)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel
    }
}