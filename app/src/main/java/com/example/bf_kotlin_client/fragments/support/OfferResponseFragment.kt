package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.bf_kotlin_client.databinding.FragmentOfferResponsesBinding
import com.example.bf_kotlin_client.viewmodels.OfferResponsesViewModel

class OfferResponseFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentOfferResponsesBinding.inflate(layoutInflater)

        binding.viewModel = OfferResponsesViewModel()

        return binding.root
    }
}