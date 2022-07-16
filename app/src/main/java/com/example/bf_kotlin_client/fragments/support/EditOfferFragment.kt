package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentEditOfferBinding
import com.example.bf_kotlin_client.viewmodels.EditOfferViewModel

class EditOfferFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEditOfferBinding.inflate(layoutInflater)
        binding.viewModel = EditOfferViewModel()
        return binding.root
    }
}