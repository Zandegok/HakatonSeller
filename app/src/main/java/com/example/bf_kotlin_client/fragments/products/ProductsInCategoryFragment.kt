package com.example.bf_kotlin_client.fragments.products

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProductsInCategoryBinding
import com.example.bf_kotlin_client.viewmodels.products.ProductsInCategoryViewModel

class ProductsInCategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentProductsInCategoryBinding.inflate(layoutInflater)

        binding.viewModel = ProductsInCategoryViewModel()

        return binding.root
    }

}