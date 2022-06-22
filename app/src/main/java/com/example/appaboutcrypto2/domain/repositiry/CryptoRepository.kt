package com.example.appaboutcrypto2.domain.repositiry

import androidx.lifecycle.LiveData
import com.example.appaboutcrypto2.data.net.model.NetModel
import com.example.appaboutcrypto2.domain.model.CryptoItem
import retrofit2.Response

interface CryptoRepository {

    suspend fun loadDataFromNet()

    fun getDataFromDB():LiveData<List<CryptoItem>>

    fun addItemToDB(cryptoItem: CryptoItem)

}