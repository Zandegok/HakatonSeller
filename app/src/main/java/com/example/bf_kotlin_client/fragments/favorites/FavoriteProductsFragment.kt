package com.example.bf_kotlin_client.fragments.favorites

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentFavoritesProductsListBinding
import com.example.bf_kotlin_client.viewmodels.favorites.FavoriteProductsViewModel

class FavoriteProductsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding = FragmentFavoritesProductsListBinding.inflate(layoutInflater)

        val favoriteProductsViewModel = FavoriteProductsViewModel()
        binding.viewModel = favoriteProductsViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root
    }
}