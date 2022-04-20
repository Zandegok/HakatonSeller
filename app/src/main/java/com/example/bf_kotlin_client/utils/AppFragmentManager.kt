package com.example.bf_kotlin_client.utils

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.fragments.support.*


class AppFragmentManager(private var fragmentManager: FragmentManager) {

    private var tabs: MutableMap<FragmentsName, ArrayList<Fragment>> = mutableMapOf(
        FragmentsName.Tutorial1Fragment to arrayListOf( Tutorial1Fragment()),
        FragmentsName.RegistrationFragment to arrayListOf(RegistrationFragment()),
        FragmentsName.ProfileAuthFragment to arrayListOf( ProfileAuthFragment()),
        FragmentsName.ProfileFragment to arrayListOf( ProfileFragment()),
        FragmentsName.CreateOfferFragment to arrayListOf( CreateOfferFragment()),
        FragmentsName.OffersFragment to arrayListOf( OffersFragment()),

    )
    private var currentTab = tabs.entries.first()

    enum class FragmentsName {
        CreateOfferFragment,
        EditOfferFragment,
        EditProfileFragment,
        OfferResponses,
        ResponsePage,
        OffersFragment,
        ProfileAuthFragment,
        ProfileFragment,
        RegistrationFragment,
        Tutorial1Fragment,
        Tutorial2Fragment
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
            FragmentsName.EditProfileFragment ->EditProfileFragment()
            FragmentsName.ResponsePage ->ResponsePageFragment()
            FragmentsName.OfferResponses ->OfferResponseFragment()
            FragmentsName.Tutorial2Fragment->Tutorial2Fragment()
            FragmentsName.EditOfferFragment ->EditOfferFragment()
            FragmentsName.ProfileAuthFragment ->ProfileAuthFragment()
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