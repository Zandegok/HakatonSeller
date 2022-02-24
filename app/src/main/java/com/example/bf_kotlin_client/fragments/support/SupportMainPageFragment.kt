package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentSupportMainPageBinding
import com.example.bf_kotlin_client.viewmodels.support.SupportMainPageViewModel

class SupportMainPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding = FragmentSupportMainPageBinding.inflate(layoutInflater)

        val supportMainPageViewModel = SupportMainPageViewModel()
        binding.viewModel = supportMainPageViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root;
    }
}