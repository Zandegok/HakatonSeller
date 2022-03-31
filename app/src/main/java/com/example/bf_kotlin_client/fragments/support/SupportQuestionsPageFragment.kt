package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentSupportQuestionsPageBinding
import com.example.bf_kotlin_client.viewmodels.support.SupportQuestionsPageViewModel

class SupportQuestionsPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding = FragmentSupportQuestionsPageBinding.inflate(layoutInflater)

        val supportMainPageViewModel = SupportQuestionsPageViewModel()
        binding.viewModel = supportMainPageViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root
    }
}