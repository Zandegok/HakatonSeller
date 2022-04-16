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
            R.id.productsSection to ProductsCategoriesFragment,
            R.id.farmersSection to FarmersListFragment,
            R.id.favouritesSection to FavoriteProductsFragment,
            R.id.profileSection to ProfileAuthFragment,
            R.id.supportSection to SupportQuestionsPageFragment
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
        var tabName = menuItemIdToTabName[menuItem.itemId]
        fragmentManager.showTab(tabName!!)
        return true
    }

}