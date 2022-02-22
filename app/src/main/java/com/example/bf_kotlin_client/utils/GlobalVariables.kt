package com.example.bf_kotlin_client.utils

import android.content.Context
import androidx.fragment.app.FragmentManager

class GlobalVariables private constructor() {
    companion object {
        val instance = GlobalVariables()
    }

    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var appDatabase: AppDatabase
    lateinit var fragmentManager: MyFragmentManager

    var apiKey: String = ""
    var androidId: String = ""
}