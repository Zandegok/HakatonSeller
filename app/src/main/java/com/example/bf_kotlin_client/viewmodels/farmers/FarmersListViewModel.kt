package com.example.bf_kotlin_client.viewmodels.farmers

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers
import com.example.bf_kotlin_client.apiworkers.FarmersApiWorker
import com.example.bf_kotlin_client.dtos.responses.FarmersResponseDto
import com.google.gson.Gson

class FarmersListViewModel {
    private var farmerApiWorker=FarmersApiWorker()

    var rvFarmersAdapter = ObservableField(RvAdapterFarmers(arrayListOf()))
    var isRefreshing=ObservableField(false)


    init {
        update()
    }

    fun update() {
        isRefreshing.set(true)
        farmerApiWorker.getAll(::updateRv)
        isRefreshing.set(false)
    }

    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, FarmersResponseDto::class.java)
        rvFarmersAdapter.set(RvAdapterFarmers(response.farmers))

    }
}