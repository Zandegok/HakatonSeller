package com.example.bf_kotlin_client.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.utils.GlobalData
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val globalData = GlobalData.instance
        globalData.applicationContext = applicationContext

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel
    }
}