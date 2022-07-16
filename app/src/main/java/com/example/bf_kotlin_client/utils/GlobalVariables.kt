package com.example.bf_kotlin_client.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.viewmodels.MainActivityViewModel

/**
 * Singleton класс для хранения глобальных переменных
 * @property onBackPressedCallback метод вызываемый при нажатии кнопки "назад"
 * @property applicationContext среда для получения глобального доступа
 * @property httpWorker класс, выполняющий запросы к серверу
 * @property appDatabase класс, выполняющий запросы к базе данных
 * @property fragmentManager класс, выполняющий переклюение фрагментов
 * @property layoutInflater класс, выполняющий отрисовку форм
 * @property buyer зарегистрированный покупатель
 * @property mainActivityViewModel класс, реализующий логику основной формы
 */
class GlobalVariables private constructor() {
    companion object {
        /**
         * Реализация Singleton составляющей
         */
        var instance = GlobalVariables()
    }
    lateinit var onBackPressedCallback: OnBackPressedCallback
    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var appDatabase: AppDatabase
    lateinit var fragmentManager: AppFragmentManager
    lateinit var layoutInflater: LayoutInflater
    lateinit var buyer: Buyer
    lateinit var mainActivityViewModel: MainActivityViewModel
}