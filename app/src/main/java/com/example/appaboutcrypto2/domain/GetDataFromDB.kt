package com.example.appaboutcrypto2.domain

import androidx.lifecycle.LiveData
import com.example.appaboutcrypto2.data.database.CryptoItemDBType
import com.example.appaboutcrypto2.domain.model.CryptoItem
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository

class GetDataFromDB (private val cryptoRepository: CryptoRepository) {

    fun getDataFromDB(): LiveData<List<CryptoItem>> {
        return cryptoRepository.getDataFromDB()
    }
}