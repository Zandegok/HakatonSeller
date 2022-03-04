package com.example.bf_kotlin_client.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProductsCategoriesBinding
import com.example.bf_kotlin_client.databinding.FragmentProductsInCategoryBinding
import com.example.bf_kotlin_client.viewmodels.products.ProductsCategoriesViewModel
import com.example.bf_kotlin_client.viewmodels.products.ProductsInCategoryViewModel

class ProductsInCategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentProductsInCategoryBinding.inflate(layoutInflater)


        var productsCategoriesViewModel =ProductsInCategoryViewModel()
        binding.viewModel = productsCategoriesViewModel

        return binding.root;
    }

}