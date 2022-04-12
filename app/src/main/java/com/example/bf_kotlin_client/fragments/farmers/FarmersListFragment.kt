package com.example.bf_kotlin_client.fragments.farmers

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentFarmersListBinding
import com.example.bf_kotlin_client.viewmodels.farmers.FarmersListViewModel

class FarmersListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentFarmersListBinding.inflate(layoutInflater)

        binding.viewModel =  FarmersListViewModel()

        return binding.root
    }
}