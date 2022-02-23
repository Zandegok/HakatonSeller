package com.example.bf_kotlin_client.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bf_kotlin_client.databinding.ActivityMainBinding
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.example.bf_kotlin_client.utils.HttpWorker
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppDatabase
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsNames.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //global variables
        var globalVariables = GlobalVariables.instance

        globalVariables.fragmentManager = AppFragmentManager(supportFragmentManager)
        globalVariables.applicationContext = applicationContext
        globalVariables.httpWorker = HttpWorker(applicationContext)
        globalVariables.appDatabase = AppDatabase.getInstance(applicationContext)
        //globalVariables.androidId = Secure.getString(applicationContext.contentResolver, Secure.ANDROID_ID)

        /*GlobalScope.launch(Dispatchers.IO) {
            var value =
                GlobalVariables.instance.appDatabase.keyValuePairsRepository.getByKey("api_key")

            if (value != null) {
                globalVariables.apiKey = value
            }
        }*/

        globalVariables.apiKey = "6425b7c09cc12971fbf65d2c6fbab7c0fd6596f3cff6ec2e693c9470e28ca47a";
        globalVariables.androidId = "100002";

        //binding

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mainActivityViewModel = MainActivityViewModel()
        binding.viewModel = mainActivityViewModel

        globalVariables.fragmentManager.replaceFragment(ProductsCategoriesFragment)

        //bottomNavigationViewActivityMain
        var bottomNavigationViewActivityMain: BottomNavigationView =
            findViewById(R.id.bottomNavigationViewActivityMain)

        bottomNavigationViewActivityMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.productsSection -> {
                    globalVariables.fragmentManager.replaceFragment(ProductsCategoriesFragment)
                    true
                }
                R.id.farmersSection -> {
                    globalVariables.fragmentManager.replaceFragment(FarmersListFragment)
                    true
                }
                else -> false
            }

        }
    }


}