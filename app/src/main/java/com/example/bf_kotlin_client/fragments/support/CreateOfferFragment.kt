package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentCreateOfferBinding
import com.example.bf_kotlin_client.viewmodels.CreateOfferViewModel

class CreateOfferFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreateOfferBinding.inflate(layoutInflater)
        binding.viewModel = CreateOfferViewModel()
        return binding.root
    }
}