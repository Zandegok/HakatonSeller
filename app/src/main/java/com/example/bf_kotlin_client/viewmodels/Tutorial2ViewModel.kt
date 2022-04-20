package com.example.bf_kotlin_client.viewmodels

import com.example.bf_kotlin_client.localdb.models.KeyValuePair
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileAuthFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.*

class Tutorial2ViewModel {
    var fragmentManager = GlobalVariables.instance.fragmentManager
    fun ok() {
        fragmentManager.showTab(ProfileAuthFragment)
        GlobalScope.launch(Dispatchers.IO) {
            GlobalVariables.instance.appDatabase.keyValuePairsRepository
                .insert(KeyValuePair("isFirst", "1"))
        }
    }
}