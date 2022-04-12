package com.example.bf_kotlin_client.viewmodels.support

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.support.RvAdapterSupport
import com.example.bf_kotlin_client.apiworkers.FaqsApiWorker
import com.example.bf_kotlin_client.dtos.responses.FaqResponseDto
import com.google.gson.Gson

class SupportQuestionsPageViewModel {
    private var faqApiWorker = FaqsApiWorker()

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