package com.example.bf_kotlin_client.utils

import android.content.Context
import android.view.LayoutInflater
import com.example.bf_kotlin_client.dtos.entities.Buyer

class GlobalVariables private constructor() {
    companion object {
        var instance = GlobalVariables()
    }

    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var appDatabase: AppDatabase
    lateinit var fragmentManager: AppFragmentManager
    lateinit var httpHeaders: MutableMap<String, String>
    lateinit var layoutInflater: LayoutInflater
    lateinit var buyer: Buyer
}