package com.example.bf_kotlin_client.fragments.products

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProductsCategoriesBinding
import com.example.bf_kotlin_client.viewmodels.products.ProductsCategoriesViewModel

class ProductsCategoriesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentProductsCategoriesBinding.inflate(layoutInflater)

        binding.viewModel = ProductsCategoriesViewModel()

        return binding.root
    }

}