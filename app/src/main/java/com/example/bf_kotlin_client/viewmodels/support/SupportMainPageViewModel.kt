package com.example.bf_kotlin_client.viewmodels.support

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.products.RvAdapterProductsCategories
import com.example.bf_kotlin_client.adapters.support.RvAdapterSupport
import com.example.bf_kotlin_client.apiworkers.FaqApiWorker
import com.example.bf_kotlin_client.dtos.entities.Faq
import com.example.bf_kotlin_client.dtos.responses.FaqResponseDto
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

class SupportMainPageViewModel {
    private var faqApiWorker = FaqApiWorker()

    var rvAdapterSupport = ObservableField(RvAdapterSupport(arrayListOf()))

    init{
        update()
    }

    fun update(){
        faqApiWorker.getAll(::updateRv)
    }

    fun updateRv(jsonData: String){
        var response = Gson().fromJson(jsonData, FaqResponseDto::class.java)

        rvAdapterSupport.set(RvAdapterSupport(response.faqs))
    }
}