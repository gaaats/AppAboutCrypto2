package com.example.appaboutcrypto2.domain

import com.example.appaboutcrypto2.domain.model.CryptoItem
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository
import javax.inject.Inject

class AddItemToDB @Inject constructor(private val cryptoRepository: CryptoRepository) {

    fun addItemToDB(cryptoItem: CryptoItem){
        cryptoRepository.addItemToDB(cryptoItem)
    }
}