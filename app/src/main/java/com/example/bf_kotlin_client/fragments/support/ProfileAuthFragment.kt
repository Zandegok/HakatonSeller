package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentCreateOfferBinding
import com.example.bf_kotlin_client.databinding.FragmentProfileAuthBinding
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.example.bf_kotlin_client.viewmodels.CreateOfferViewModel
import com.example.bf_kotlin_client.viewmodels.ProfileAuthViewModel
import kotlinx.coroutines.*

class ProfileAuthFragment : Fragment() {
    private val profileAuthViewModel = ProfileAuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentProfileAuthBinding.inflate(layoutInflater)

        binding.viewModel = profileAuthViewModel

        return binding.root
    }
}