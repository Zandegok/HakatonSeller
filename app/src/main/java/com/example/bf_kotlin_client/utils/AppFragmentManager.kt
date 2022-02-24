package com.example.bf_kotlin_client.utils

import androidx.fragment.app.Fragment
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
//        val factory=fragmentManager.fragmentFactory
//        val classLoader=GlobalVariables.instance.applicationContext.classLoader
        val containerId = R.id.frameLayoutActivityMain
        with(fragmentManager.beginTransaction()) {
//            for (fragmentName in FragmentsNames.values()){
//                add(factory.instantiate(classLoader,fragmentName.name),fragmentName.name)
//            }
            add(containerId,ProductsCategoriesFragment(), FragmentsNames.ProductsCategoriesFragment.name)
            add(containerId, FavoriteProductsFragment(), FragmentsNames.FavoriteProductsFragment.name)
            add(containerId, FarmersListFragment(), FragmentsNames.FarmersListFragment.name)
            add(containerId, ProfileFragment(), FragmentsNames.ProfileFragment.name)
            add(containerId, SupportMainPageFragment(), FragmentsNames.SupportMainPageFragment.name)

            commit()
        }
    }

    fun replaceFragment(fragmentName: FragmentsNames) {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        var fragment = fragmentManager.findFragmentByTag(fragmentName.name)!!
        with(fragmentManager.beginTransaction()) {
            for (fragment in fragmentManager.fragments)
                attach(fragment)
            show(fragment)
            commitNow()
        }
    }
}