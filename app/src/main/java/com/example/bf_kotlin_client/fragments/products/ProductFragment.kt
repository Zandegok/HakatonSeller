package com.example.bf_kotlin_client.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProductBinding
import com.example.bf_kotlin_client.viewmodels.products.ProductViewModel

class ProductFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentProductBinding.inflate(layoutInflater)

        var productViewModel = ProductViewModel()
        binding.viewModel = productViewModel

        return binding.root;
    }
}