package com.example.bf_kotlin_client.viewmodels

import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.*
import com.example.bf_kotlin_client.utils.GlobalVariables

class MainActivityViewModel {
    private var fragmentManager = GlobalVariables.instance.fragmentManager

    private var menuItemIdToTabName: MutableMap<Int, AppFragmentManager.FragmentsName> =
        mutableMapOf(
            R.id.myRequestsSection to OffersFragment,
            R.id.createSection to CreateOfferFragment,
            R.id.profileSection to ProfileAuthFragment,
        )

    var onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentManager.popBackStack()
        }
    }

    fun onItemSelected(menuItem: MenuItem): Boolean {
        var tabName = menuItemIdToTabName[menuItem.itemId]
        fragmentManager.showTab(tabName!!)
        return true
    }

}