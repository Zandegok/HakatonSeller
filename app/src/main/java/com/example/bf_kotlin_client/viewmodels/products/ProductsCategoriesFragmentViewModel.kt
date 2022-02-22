package com.example.bf_kotlin_client.viewmodels.products

import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.utils.GlobalVariables

class ProductsCategoriesFragmentViewModel {
    val fieldData: ObservableField<String> = ObservableField("data....")

    fun createToast(){
        Toast.makeText(GlobalVariables.instance.applicationContext,"AAAA!", Toast.LENGTH_LONG).show()
    }
}