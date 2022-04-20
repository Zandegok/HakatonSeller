package com.example.bf_kotlin_client.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel

class GlobalVariables private constructor() {
    companion object {
        var instance = GlobalVariables()
    }

    lateinit var onBackPressedCallback: OnBackPressedCallback
    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var appDatabase: AppDatabase
    lateinit var fragmentManager: AppFragmentManager
    lateinit var httpHeaders: MutableMap<String, String>
    lateinit var layoutInflater: LayoutInflater
    lateinit var buyer: Buyer
    lateinit var mainActivityViewModel: MainActivityViewModel
}