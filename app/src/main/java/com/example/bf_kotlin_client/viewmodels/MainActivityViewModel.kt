package com.example.bf_kotlin_client.viewmodels

import android.opengl.Visibility
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.*
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivityViewModel {
    private var fragmentManager = GlobalVariables.instance.fragmentManager
    var bottomNavigationViewEnabled = false
        set(value) {
            field = value
            bottomNavigationViewVisibility.set(if (value) VISIBLE else INVISIBLE)
        }
    var bottomNavigationViewVisibility = ObservableField(INVISIBLE)
    private var menuItemIdToTabName: MutableMap<Int, AppFragmentManager.FragmentsName> =
        mutableMapOf(
            R.id.profileSection to ProfileFragment,
            R.id.createSection to CreateOfferFragment,
            R.id.myRequestsSection to OffersFragment
        )

    var onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentManager.popBackStack()
        }
    }
    init{
        GlobalVariables.instance.onBackPressedCallback = onBackPressedCallback
    }
    fun onItemSelected(menuItem: MenuItem): Boolean {
        if (!bottomNavigationViewEnabled) {
            return false
        }
        var tabName = menuItemIdToTabName[menuItem.itemId]
        fragmentManager.showTab(tabName!!)
        return true
    }

}