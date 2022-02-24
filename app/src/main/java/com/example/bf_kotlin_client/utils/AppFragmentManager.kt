package com.example.bf_kotlin_client.utils

import androidx.fragment.app.FragmentManager
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.fragments.farmers.FarmersListFragment
import com.example.bf_kotlin_client.fragments.favorites.FavoriteProductsFragment
import com.example.bf_kotlin_client.fragments.products.ProductsCategoriesFragment
import com.example.bf_kotlin_client.fragments.profile.ProfileFragment
import com.example.bf_kotlin_client.fragments.support.SupportMainPageFragment


class AppFragmentManager(private var fragmentManager: FragmentManager) {

    enum class FragmentsNames {
        FarmersListFragment,
        FavoriteProductsFragment,
        ProductsCategoriesFragment,
        ProfileFragment,
        SupportMainPageFragment,
    }

    init {

        var containerId = R.id.frameLayoutActivityMain

        var fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(
            containerId,
            ProductsCategoriesFragment(),
            FragmentsNames.ProductsCategoriesFragment.name
        )

        fragmentTransaction.add(
            containerId,
            FavoriteProductsFragment(),
            FragmentsNames.FavoriteProductsFragment.name
        )

        fragmentTransaction.add(
            containerId,
            FarmersListFragment(),
            FragmentsNames.FarmersListFragment.name
        )

        fragmentTransaction.add(containerId, ProfileFragment(), FragmentsNames.ProfileFragment.name)

        fragmentTransaction.add(
            containerId,
            SupportMainPageFragment(),
            FragmentsNames.SupportMainPageFragment.name
        )

        fragmentTransaction.commit()
    }

    fun replaceFragment(fragmentName: FragmentsNames) {
        fragmentManager.executePendingTransactions()//защита от асинхронности

        var foundFragment = fragmentManager.findFragmentByTag(fragmentName.name)!!

        var fragmentTransaction = fragmentManager.beginTransaction()

        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }

        fragmentTransaction.show(foundFragment)
        fragmentTransaction.commitNow()
    }
}