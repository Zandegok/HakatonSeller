package com.example.bf_kotlin_client.fragments.farmers

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentFarmerBinding
import com.example.bf_kotlin_client.viewmodels.farmers.FarmerViewModel

class FarmerFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentFarmerBinding.inflate(layoutInflater)

        binding.viewModel = FarmerViewModel()

        return binding.root
    }
}