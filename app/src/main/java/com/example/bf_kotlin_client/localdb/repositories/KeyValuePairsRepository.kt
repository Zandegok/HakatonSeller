package com.example.bf_kotlin_client.localdb.repositories

import androidx.room.*
import com.example.bf_kotlin_client.localdb.models.KeyValuePair

/**
 * Интерфейс для работы с таблицей [пар ключ/значение][KeyValuePair] [локальной базы данных][com.example.bf_kotlin_client.utils.AppDatabase]
 *
 */
@Dao
interface KeyValuePairsRepository {
    /**
     * выдаёт значение из базы данных по ключу
     */
    @Query("SELECT `value` from key_value_pairs WHERE `key` = :key")
    suspend fun getByKey(key: String): String?

    /**
     * Добавляет новую пару ключ/значение в базу данных
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(keyValuePair: KeyValuePair)

    /**
     * Задаёт новое значение существующему ключу
     *
     * @param keyValuePair пара со старым ключом и новым значением
     */
    @Update
    suspend fun update(keyValuePair: KeyValuePair)

    /**
     * Полностью отчищают таблицу ключ/значений
     *
     */
    @Query("DELETE FROM key_value_pairs")
    suspend fun deleteAll()

    /**
     * Удаляет пару ключ/значение по ключу
     *
     */
    @Query("DELETE FROM key_value_pairs WHERE `key` = :key")
    suspend fun deleteByKey(key: String)
}