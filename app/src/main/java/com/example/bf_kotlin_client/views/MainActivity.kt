package com.example.bf_kotlin_client.views

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.utils.*
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var globalVariables = GlobalVariables.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        globalVariables.applicationContext = this
        globalVariables.httpWorker = HttpWorker(this)
        globalVariables.layoutInflater = LayoutInflater.from(this)

        val appDatabase = AppDatabase.getInstance(applicationContext)
        globalVariables.appDatabase = appDatabase
        globalVariables.fragmentManager = AppFragmentManager(supportFragmentManager)
        globalVariables.buyer = Buyer()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel
        globalVariables.mainActivityViewModel = mainActivityViewModel
        GlobalScope.launch(Dispatchers.Main) {
            show(appDatabase.keyValuePairsRepository.getByKey("isFirst"))
        }

    }

    private fun show(isFirst: String?) {
        if (isFirst == null) {
            globalVariables.fragmentManager.showTab(AppFragmentManager.FragmentsName.Tutorial1Fragment)
        } else {
            globalVariables.fragmentManager.showTab(AppFragmentManager.FragmentsName.ProfileAuthFragment)
        }
    }
}