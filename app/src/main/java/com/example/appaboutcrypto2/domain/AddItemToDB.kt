package com.example.appaboutcrypto2.domain

import com.example.appaboutcrypto2.domain.model.CryptoItem
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository

class AddItemToDB (private val cryptoRepository: CryptoRepository) {

    suspend fun addItemToDB(cryptoItem: CryptoItem){
        cryptoRepository.addItemToDB(cryptoItem)
    }
}