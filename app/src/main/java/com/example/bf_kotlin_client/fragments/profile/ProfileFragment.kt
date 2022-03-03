package com.example.bf_kotlin_client.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProductsCategoriesBinding
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.viewmodels.products.ProductsCategoriesViewModel
import com.example.bf_kotlin_client.viewmodels.profile.ProfileViewModel

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentProfileBinding.inflate(layoutInflater)
        var profileViewModel = ProfileViewModel()
        binding.viewModel = profileViewModel

        return binding.root;
    }
}