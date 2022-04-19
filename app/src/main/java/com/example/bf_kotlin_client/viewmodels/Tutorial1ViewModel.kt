package com.example.bf_kotlin_client.viewmodels

import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.Tutorial2Fragment
import com.example.bf_kotlin_client.utils.GlobalVariables

class Tutorial1ViewModel {
    var fragmentManager = GlobalVariables.instance.fragmentManager
    fun next(){
        fragmentManager.openFragmentAboveMain(Tutorial2Fragment)
    }
}