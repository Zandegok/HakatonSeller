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

        val binding = FragmentFarmerBinding.inflate(layoutInflater)

        val farmerViewModel = FarmerViewModel()
        binding.viewModel = farmerViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root
    }
}