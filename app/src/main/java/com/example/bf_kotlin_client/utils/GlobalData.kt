package com.example.bf_kotlin_client.utils

import android.content.Context

class GlobalData {
    companion object {
        val instance = GlobalData()
    }

    lateinit var applicationContext: Context
}