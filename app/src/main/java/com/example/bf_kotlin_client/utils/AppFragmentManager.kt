package com.example.bf_kotlin_client.utils

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.fragments.farmers.FarmersListFragment
import com.example.bf_kotlin_client.fragments.favorites.FavoriteProductsFragment
import com.example.bf_kotlin_client.fragments.products.ProductsCategoriesFragment
import com.example.bf_kotlin_client.fragments.products.ProductsInCategoryFragment
import com.example.bf_kotlin_client.fragments.profile.ProfileFragment
import com.example.bf_kotlin_client.fragments.support.SupportMainPageFragment


class AppFragmentManager(private var fragmentManager: FragmentManager) {

    val mainFragmentsNames =
        FragmentsNames.FarmersListFragment..FragmentsNames.SupportMainPageFragment

    enum class FragmentsNames {
        FarmersListFragment,
        FavoriteProductsFragment,
        ProductsCategoriesFragment,
        ProfileFragment,
        SupportMainPageFragment,
        ProductsInCategoryFragment,
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

    fun showOneOfMainFragment(fragmentName: FragmentsNames) {
        if (fragmentName !in mainFragmentsNames) {
            throw IllegalArgumentException("$fragmentName is not main fragment")
        }
        fragmentManager.executePendingTransactions()//защита от асинхронности

        var foundFragment: Fragment = fragmentManager.findFragmentByTag(fragmentName.name)!!

        var fragmentTransaction = fragmentManager.beginTransaction()

        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }

        fragmentTransaction.show(foundFragment)
        fragmentTransaction.addToBackStack(fragmentName.name)
        fragmentTransaction.commit()
    }

    fun openFragmentAboveMain(fragmentName: FragmentsNames) {
        fragmentManager.executePendingTransactions()

        var newFragment: Fragment = when (fragmentName) {
            FragmentsNames.ProductsInCategoryFragment -> ProductsInCategoryFragment()
            else -> throw IllegalArgumentException("This Fragment cant be instantiate")
        }

        var fragmentTransaction = fragmentManager.beginTransaction()

        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }

        fragmentTransaction.add(newFragment, fragmentName.name)
        fragmentTransaction.addToBackStack(fragmentName.name)
        fragmentTransaction.commit()

    }

    fun <T : ViewDataBinding?> getBinding(fragmentName: FragmentsNames): T? {
        fragmentManager.executePendingTransactions()
        return DataBindingUtil.getBinding<T>(
            fragmentManager.findFragmentByTag(fragmentName.name)!!.requireView())
    }

    fun popBackStack() {
        fragmentManager.executePendingTransactions()
        if (fragmentManager.backStackEntryCount < 2) return
        val backStackEntry =
            fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 2)
        fragmentManager.popBackStack()
        var foundFragment: Fragment = fragmentManager.findFragmentByTag(backStackEntry.name!!)!!
        var fragmentTransaction = fragmentManager.beginTransaction()
        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }
        fragmentTransaction.show(foundFragment)
        fragmentTransaction.commit()
    }
}