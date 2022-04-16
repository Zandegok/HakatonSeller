package com.example.bf_kotlin_client.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback

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
}