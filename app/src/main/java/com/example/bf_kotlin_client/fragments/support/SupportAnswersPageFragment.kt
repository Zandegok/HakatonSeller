package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentSupportAnswersPageBinding
import com.example.bf_kotlin_client.viewmodels.support.SupportAnswersPageViewModel

class SupportAnswersPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        var binding =FragmentSupportAnswersPageBinding.inflate(layoutInflater)

        binding.viewModel = SupportAnswersPageViewModel()

        return binding.root
    }
}