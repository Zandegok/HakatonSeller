package com.example.bf_kotlin_client.viewmodels

import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsNames.*
import com.example.bf_kotlin_client.utils.GlobalVariables

class MainActivityViewModel {
    private val fragmentManager = GlobalVariables.instance.fragmentManager

    var onBackPressedCallback=object :OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            fragmentManager.popBackStack()
        }
    }

    fun onItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.productsSection -> {
                fragmentManager.showOneOfMainFragment(ProductsCategoriesFragment)
                return true
            }
            R.id.farmersSection -> {
                fragmentManager.showOneOfMainFragment(FarmersListFragment)
                return true
            }
            R.id.favouritesSection -> {
                fragmentManager.showOneOfMainFragment(FavoriteProductsFragment)
                return true
            }
            R.id.profileSection -> {
                fragmentManager.showOneOfMainFragment(ProfileFragment)
                return true
            }
            R.id.supportSection -> {
                fragmentManager.showOneOfMainFragment(SupportMainPageFragment)
                return true
            }
            else -> return false
        }

    }


}