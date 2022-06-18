package com.example.appaboutcrypto2.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appaboutcrypto2.domain.model.CryptoItem


@Dao
interface CryptoDAO {
    @Query("SELECT * FROM crypto_table ORDER BY inUsd")
    fun getCryptoList(): LiveData<List<CryptoItemDBType>>

//    @Query("SELECT * FROM crypto_table WHERE id=:cryptoId LIMIT 1")
//    suspend fun getSingleItem (cryptoId:String):CryptoItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItemToCryptoList (cryptoItemDBType: CryptoItemDBType)

    @Query("DELETE FROM crypto_table")
    fun deleteAllUsers()
}
///lolo