package com.example.bf_kotlin_client.fragments.farmers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentFarmersListBinding
import com.example.bf_kotlin_client.viewmodels.farmers.FarmersListViewModel

class FarmersListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFarmersListBinding.inflate(layoutInflater)

        val farmersListViewModel = FarmersListViewModel()
        binding.viewModel = farmersListViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root;
    }
}