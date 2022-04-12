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

        var binding = FragmentSupportQuestionsPageBinding.inflate(layoutInflater)

        binding.viewModel = SupportQuestionsPageViewModel()

        return binding.root
    }
}