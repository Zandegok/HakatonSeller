package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProfileAuthBinding
import com.example.bf_kotlin_client.viewmodels.ProfileAuthViewModel

class ProfileAuthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentProfileAuthBinding.inflate(layoutInflater)
        binding.viewModel = ProfileAuthViewModel()
        return binding.root
    }
}