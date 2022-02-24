package com.example.bf_kotlin_client.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProductsCategoriesBinding
import com.example.bf_kotlin_client.viewmodels.products.ProductsCategoriesViewModel

class ProductsCategoriesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentProductsCategoriesBinding.inflate(layoutInflater)

        val productsCategoriesViewModel = ProductsCategoriesViewModel()
        binding.viewModel = productsCategoriesViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root;
    }
}