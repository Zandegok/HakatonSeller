package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentEditProfileBinding
import com.example.bf_kotlin_client.databinding.FragmentResponsePageBinding
import com.example.bf_kotlin_client.viewmodels.EditProfileViewModel
import com.example.bf_kotlin_client.viewmodels.ResponsePageViewModel

class ResponsePageFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentResponsePageBinding.inflate(layoutInflater)

        binding.viewModel = ResponsePageViewModel()

        return binding.root
    }
}