package com.example.bf_kotlin_client.utils

import android.content.Context

class GlobalVariables private constructor() {
    companion object {
        val instance = GlobalVariables()
    }

    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var appDatabase: AppDatabase

    var apiKey: String = ""
    var androidId: String = ""
}