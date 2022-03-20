package com.example.bf_kotlin_client.viewmodels.support

import com.example.bf_kotlin_client.apiworkers.FaqApiWorker
import com.example.bf_kotlin_client.dtos.entities.Faq
import com.example.bf_kotlin_client.dtos.responses.FaqResponseDto
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

class SupportMainPageViewModel {
    var faqApiWorker= FaqApiWorker()
    var faqs:ArrayList<Faq> =arrayListOf()
    init{
        faqApiWorker.getAll {
            var response = Gson().fromJson(it, FaqResponseDto::class.java)
            faqs=response.faqs
        }
    }
}