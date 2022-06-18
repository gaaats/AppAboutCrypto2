package com.example.appaboutcrypto2.domain.repositiry

import androidx.lifecycle.LiveData
import com.example.appaboutcrypto2.domain.model.CryptoItem

interface CryptoRepository {

    fun loadDataFromNet()

    fun getDataFromDB():LiveData<List<CryptoItem>>

    suspend fun addItemToDB(cryptoItem: CryptoItem)
}