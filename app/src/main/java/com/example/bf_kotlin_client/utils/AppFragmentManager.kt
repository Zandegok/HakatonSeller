package com.example.bf_kotlin_client.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.fragments.farmers.FarmersListFragment
import com.example.bf_kotlin_client.fragments.products.ProductsCategoriesFragment

class AppFragmentManager(private var fragmentManager: FragmentManager) {

    enum class FragmentsNames(var fname: String) {
        ProductsCategoriesFragment("ProductsCategoriesFragment"),
        FarmersListFragment("FarmersListFragment"),
        BLUE("")
    }

    private var fragments = hashMapOf<String, Fragment>(
        "ProductsCategoriesFragment" to ProductsCategoriesFragment(),
        "FarmersListFragment" to FarmersListFragment()
    )

    fun replaceFragment(fragmentName: FragmentsNames){
        var fragmentTransaction = fragmentManager.beginTransaction()

        var fragment = fragments[fragmentName.fname]!!

        fragmentTransaction.replace(R.id.frameLayoutActivityMain, fragment)

        fragmentTransaction.commitNow()
    }
}