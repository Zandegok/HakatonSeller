package com.example.bf_kotlin_client.viewmodels.profile

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.apiworkers.ClientsApiWorker
import com.example.bf_kotlin_client.dtos.responses.ClientResponse

class ProfileViewModel {
    var client = ClientResponse()
}