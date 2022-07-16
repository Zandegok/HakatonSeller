package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentOffersBinding
import com.example.bf_kotlin_client.viewmodels.OffersViewModel

class OffersFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOffersBinding.inflate(layoutInflater)
        binding.viewModel = OffersViewModel()
        return binding.root
    }
}