package com.example.bf_kotlin_client.utils

import android.content.Context
import com.bumptech.glide.load.model.Headers

class GlobalVariables private constructor() {
    companion object {
        val instance = GlobalVariables()
    }

    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var appDatabase: AppDatabase
    lateinit var fragmentManager: AppFragmentManager

    var apiKey: String = ""
    var deviceId: String = ""

    val headers by lazy {
        Headers{
        mutableMapOf("API_KEY" to apiKey, "DEVICE_ID" to deviceId)
    }
    }
}