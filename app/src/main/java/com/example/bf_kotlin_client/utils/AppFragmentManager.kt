package com.example.bf_kotlin_client.utils

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.fragments.support.*

/**
 * Класс, реализующий переключение независимых вкладок и фрагментов внутри них
 *
 * @property fragmentManager класс, дающий доступ к управлению фрагментами
 */
class AppFragmentManager(private var fragmentManager: FragmentManager) {
    /**
     * список вкладок, меджу которыми происходит переключение по типу главного фрагмента
     */
    private var tabs: MutableMap<FragmentsName, ArrayList<Fragment>> = mutableMapOf(
        FragmentsName.Tutorial1Fragment to arrayListOf( Tutorial1Fragment()),
        FragmentsName.RegistrationFragment to arrayListOf(RegistrationFragment()),
        FragmentsName.ProfileAuthFragment to arrayListOf( ProfileAuthFragment()),
        FragmentsName.ProfileFragment to arrayListOf( ProfileFragment()),
        FragmentsName.CreateOfferFragment to arrayListOf( CreateOfferFragment()),
        FragmentsName.OffersFragment to arrayListOf( OffersFragment()),

    )

    /**
     * открытая вкладка
     */
    private var currentTab = tabs.entries.first()

    /**
     * Enum, каждый элемент которого соответствует доступным фрагментам
     *
     */
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

    /**
     * отрисовывает все фрагменты, уже лежащие в списке вкладок
     */
    init {
        val containerId = R.id.frameLayoutActivityMain
        val fragmentTransaction = fragmentManager.beginTransaction()
        for (tab in tabs)
            fragmentTransaction.add(containerId, tab.value[0])
        fragmentTransaction.commit()
    }

    /**
     * Меняет открытую вкладку
     *
     * @param fragmentName
     */
    fun showTab(fragmentName: FragmentsName) {
        if (fragmentName !in tabs.keys) {
            throw IllegalArgumentException("$fragmentName is not main fragment")
        }
        fragmentManager.executePendingTransactions()//защита от асинхронности
        val newTab = tabs.entries.first { it.key == fragmentName }
        if (newTab == currentTab) {
            refreshCurrentTab()
            return
        }
        val fragmentTransaction = fragmentManager.beginTransaction()
        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }
        fragmentTransaction.show(newTab.value.last())
        fragmentTransaction.commit()
        currentTab = newTab
    }

    /**
     * приводит открытую вкладку к первоначальному состоянию
     *
     */
    private fun refreshCurrentTab() {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        val newTabMainFragment =
            currentTab.value.first().javaClass.constructors[0].newInstance() as Fragment
        val fragmentTransaction = fragmentManager.beginTransaction()
        for (fragment in currentTab.value)
            fragmentTransaction.remove(fragment)
        fragmentTransaction.add(R.id.frameLayoutActivityMain, newTabMainFragment)
        fragmentTransaction.commit()
        currentTab.setValue(arrayListOf(newTabMainFragment))
    }

    /**
     * Добавляет новй фрагмент поверх предыдущего в текущей вкладке
     *
     * @param fragmentName название фрагмента
     */
    fun openFragmentAboveMain(fragmentName: FragmentsName) {
        fragmentManager.executePendingTransactions()//защита от асинхронности

        val newFragment: Fragment = when (fragmentName) {
            FragmentsName.EditProfileFragment ->EditProfileFragment()
            FragmentsName.ResponsePage ->ResponsePageFragment()
            FragmentsName.OfferResponses ->OfferResponseFragment()
            FragmentsName.Tutorial2Fragment->Tutorial2Fragment()
            FragmentsName.EditOfferFragment ->EditOfferFragment()
            FragmentsName.ProfileAuthFragment ->ProfileAuthFragment()
            else -> throw IllegalArgumentException("This Fragment can't be instantiate")
        }

        val fragmentTransaction = fragmentManager.beginTransaction()

        for (fragment in fragmentManager.fragments) {
            fragmentTransaction.hide(fragment)
        }

        val containerId = R.id.frameLayoutActivityMain
        fragmentTransaction.add(containerId, newFragment, fragmentName.name)
        fragmentTransaction.commit()
        currentTab.value.add(newFragment)

    }

    /**
     * Получает ViewDataBinding, привязанный к последнему открытому фрагменту в текущей вкладке
     *
     * @param T тип привянного ViewDataBinding
     * @return Если тип T совпадает с типом ViewDataBinding, что привязано к фрагменту, то возвращает его, иначе null
     */
    fun <T : ViewDataBinding?> getCurrentFragmentBinding(): T? {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        return DataBindingUtil.getBinding<T>(currentTab.value.last().requireView())
    }

    /**
     * удаляет последний фрагмент в текущей вкладке, если там всего 1 фрагмент, то обовляет его
     *
     */
    fun popBackStack() {
        fragmentManager.executePendingTransactions()//защита от асинхронности
        val currentTabFragments = currentTab.value
        if (currentTabFragments.size == 1) {
            refreshCurrentTab()
            return
        }
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(currentTabFragments.last())
        currentTabFragments.removeAt(currentTabFragments.lastIndex)
        fragmentTransaction.show(currentTabFragments.last())
        fragmentTransaction.commit()
    }
}