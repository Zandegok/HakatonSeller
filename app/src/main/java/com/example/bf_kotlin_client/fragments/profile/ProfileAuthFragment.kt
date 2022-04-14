package com.example.bf_kotlin_client.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProfileAuthBinding
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.viewmodels.profile.ProfileAuthViewModel
import com.example.bf_kotlin_client.viewmodels.profile.ProfileViewModel

class ProfileAuthFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var binding = FragmentProfileAuthBinding.inflate(layoutInflater)

        binding.viewModel = ProfileAuthViewModel()

        return binding.root
    }
}