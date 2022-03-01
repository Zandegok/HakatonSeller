package com.example.bf_kotlin_client.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.viewmodels.profile.ProfileViewModel

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentProfileBinding.inflate(layoutInflater)

        val profileViewModel = ProfileViewModel()
        binding.viewModel = profileViewModel.apply {
            image.run {
                addOnPropertyChangedCallback(object :
                        Observable.OnPropertyChangedCallback() {
                        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                            binding.profileImageView.setImageBitmap(get())
                        }
                    })
            }
        }
        return binding.root;
    }
}