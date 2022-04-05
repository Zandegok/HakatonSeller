package com.example.bf_kotlin_client.fragments.profile

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.viewmodels.profile.ProfileViewModel

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.viewModel = ProfileViewModel()

        return binding.root
    }
}