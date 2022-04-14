package com.example.bf_kotlin_client.utils

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.fragments.farmers.FarmerFragment
import com.example.bf_kotlin_client.fragments.farmers.FarmersListFragment
import com.example.bf_kotlin_client.fragments.favorites.FavoriteProductsFragment
import com.example.bf_kotlin_client.fragments.products.*
import com.example.bf_kotlin_client.fragments.profile.ProfileAuthFragment
import com.example.bf_kotlin_client.fragments.profile.ProfileFragment
import com.example.bf_kotlin_client.fragments.support.SupportQuestionsPageFragment
import com.example.bf_kotlin_client.fragments.support.SupportAnswersPageFragment


class AppFragmentManager(private var fragmentManager: FragmentManager) {

    private var tabs: MutableMap<FragmentsName, ArrayList<Fragment>> = mutableMapOf(
        FragmentsName.FarmersListFragment to arrayListOf(FarmersListFragment()),
        FragmentsName.FavoriteProductsFragment to arrayListOf(FavoriteProductsFragment()),
        FragmentsName.ProductsCategoriesFragment to arrayListOf(ProductsCategoriesFragment()),
        FragmentsName.ProfileAuthFragment to arrayListOf(ProfileAuthFragment()),
        FragmentsName.SupportQuestionsPageFragment to arrayListOf(SupportQuestionsPageFragment()),
    )
    private var currentTab = tabs.entries.first()

    enum class FragmentsName {
        FarmersListFragment,
        FavoriteProductsFragment,
        ProductsCategoriesFragment,
        ProfileFragment,
        ProfileAuthFragment,
        SupportQuestionsPageFragment,
        ProductsInCategoryFragment,
        ProductFragment,
        SupportAnswersPageFragment,
        FarmerFragment,
    }

    init {
        var containerId = R.id.frameLayoutActivityMain
        var fragmentTransaction = fragmentManager.beginTransaction()
        for (tab in tabs)
            fragmentTransaction.add(containerId, tab.value[0])
        fragmentTransaction.commit()
    }

    fun showTab(fragmentName: FragmentsName) {
        if (fragmentName !in tabs.keys) {
            throw IllegalArgumentException("$fragmentName is not main fragment")
        }
        fragmentManager.executePendingTransactions()//защита от асинхронности
        var newTab = tabs.entries.first { it.key == fragmentName }
        if (newTab == currentTab) {
            refreshCurrentTab()
            return
        }
        var fragmentTransaction = fragmentManager.beginTransaction()
        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }
        fragmentTransaction.show(newTab.value.last())
        fragmentTransaction.commit()
        currentTab = newTab
    }

    fun refreshCurrentTab() {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        var newTabMainFragment =
            currentTab.value.first().javaClass.constructors[0].newInstance() as Fragment
        var fragmentTransaction = fragmentManager.beginTransaction()
        for (fragment in currentTab.value)
            fragmentTransaction.remove(fragment)
        fragmentTransaction.add(R.id.frameLayoutActivityMain, newTabMainFragment)
        fragmentTransaction.commit()
        currentTab.setValue(arrayListOf(newTabMainFragment))
    }

    fun openFragmentAboveMain(fragmentName: FragmentsName) {
        fragmentManager.executePendingTransactions()//защита от асинхронности

        var newFragment: Fragment = when (fragmentName) {
            FragmentsName.ProductsInCategoryFragment -> ProductsInCategoryFragment()
            FragmentsName.ProductFragment -> ProductFragment()
            FragmentsName.SupportAnswersPageFragment -> SupportAnswersPageFragment()
            FragmentsName.FarmerFragment-> FarmerFragment()
            FragmentsName.ProfileFragment-> ProfileFragment()
            else -> throw IllegalArgumentException("This Fragment can't be instantiate")
        }

        var fragmentTransaction = fragmentManager.beginTransaction()

        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }

        var containerId = R.id.frameLayoutActivityMain
        fragmentTransaction.add(containerId, newFragment, fragmentName.name)
        fragmentTransaction.commit()
        currentTab.value.add(newFragment)

    }

    fun <T : ViewDataBinding?> getCurrentFragmentBinding(): T? {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        return DataBindingUtil.getBinding<T>(currentTab.value.last().requireView())
    }

    fun popBackStack() {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        var currentTabFragments = currentTab.value
        if (currentTabFragments.size == 1) {
            refreshCurrentTab()
            return
        }
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(currentTabFragments.last())
        currentTabFragments.removeAt(currentTabFragments.lastIndex)
        fragmentTransaction.show(currentTabFragments.last())
        fragmentTransaction.commit()
    }
}