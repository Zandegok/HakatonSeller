package com.example.bf_kotlin_client.viewmodels

import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.*
import com.example.bf_kotlin_client.utils.GlobalVariables

class MainActivityViewModel {
    private val fragmentManager = GlobalVariables.instance.fragmentManager


    var selectedItemId: ObservableField<Int> = ObservableField(0)
    var onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentManager.popBackStack()
        }
    }

    fun onItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.productsSection -> {
                fragmentManager.showTab(ProductsCategoriesFragment)
                return true
            }
            R.id.farmersSection -> {
                fragmentManager.showTab(FarmersListFragment)
                return true
            }
            R.id.favouritesSection -> {
                fragmentManager.showTab(FavoriteProductsFragment)
                return true
            }
            R.id.profileSection -> {
                fragmentManager.showTab(ProfileFragment)
                return true
            }
            R.id.supportSection -> {
                fragmentManager.showTab(SupportMainPageFragment)
                return true
            }
            else -> return false
        }

    }

}