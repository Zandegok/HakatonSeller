package com.example.bf_kotlin_client.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bf_kotlin_client.utils.GlobalData

class MainActivityViewModel {
    val fieldApiKey: ObservableField<String> = ObservableField("data....")

    fun updateFieldApiKey(data: String){
        fieldApiKey.set(data.toString())
    }

    fun authorize(){
        val globalData = GlobalData.instance

        val volleyQueue = Volley.newRequestQueue(globalData.applicationContext)

        var request = object : StringRequest(
            Method.POST,
            "http://151.248.113.116:8080/mobile/productsCategories/getAll",
            {
                updateFieldApiKey(it)
            },
            {
                Toast.makeText(globalData.applicationContext, it.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val myHeaders = HashMap<String, String>()
                myHeaders["API_KEY"] = "f9f195057e841496f6ba4bb0234224d1917f7efb73295eb79585857f080c17e4"
                myHeaders["DEVICE_ID"] = "2sdfssdf3"
                return myHeaders
            }
        }

        volleyQueue.add(request)
    }
}