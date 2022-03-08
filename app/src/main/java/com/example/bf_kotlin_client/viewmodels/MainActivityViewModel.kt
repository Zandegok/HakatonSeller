package com.example.bf_kotlin_client.viewmodels

import android.view.MenuItem
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables

class MainActivityViewModel {
    private val fragmentManager = GlobalVariables.instance.fragmentManager

    fun onItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.productsSection -> {
                fragmentManager.replaceFragment(AppFragmentManager.FragmentsNames.ProductsCategoriesFragment)
                return true
            }
            R.id.farmersSection -> {
                fragmentManager.replaceFragment(AppFragmentManager.FragmentsNames.FarmersListFragment)
                return true
            }
            R.id.favouritesSection -> {
                fragmentManager.replaceFragment(AppFragmentManager.FragmentsNames.FavoriteProductsFragment)
                return true
            }
            R.id.profileSection -> {
                fragmentManager.replaceFragment(AppFragmentManager.FragmentsNames.ProfileFragment)
                return true
            }
            R.id.supportSection -> {
                fragmentManager.replaceFragment(AppFragmentManager.FragmentsNames.SupportMainPageFragment)
                return true
            }
            else -> return false
        }
    }

}