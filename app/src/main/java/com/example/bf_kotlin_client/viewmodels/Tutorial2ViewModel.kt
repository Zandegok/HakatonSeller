package com.example.bf_kotlin_client.viewmodels

import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileAuthFragment
import com.example.bf_kotlin_client.utils.GlobalVariables

class Tutorial2ViewModel {
    var fragmentManager = GlobalVariables.instance.fragmentManager
    fun ok(){
        fragmentManager.showTab(ProfileAuthFragment)
    }
}