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
    private var menuItemIdToTabName:MutableMap<Int, AppFragmentManager.FragmentsName> =
        mutableMapOf(
            R.id.productsSection to ProductsCategoriesFragment,
            R.id.farmersSection to FarmersListFragment,
            R.id.favouritesSection to FavoriteProductsFragment,
            R.id.profileSection to ProfileFragment,
            R.id.supportSection to SupportQuestionsPageFragment  )

    var selectedItemId: ObservableField<Int> = ObservableField(0)
    var onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentManager.popBackStack()
        }
    }

    fun onItemSelected(menuItem: MenuItem): Boolean {
        var tabName=menuItemIdToTabName[menuItem.itemId]
        if (tabName!=null){
            fragmentManager.showTab(tabName)
            return true
        }
        else {
            return false
        }
    }

}