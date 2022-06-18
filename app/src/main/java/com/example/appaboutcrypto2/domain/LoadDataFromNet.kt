package com.example.appaboutcrypto2.domain

import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository

class LoadDataFromNet(private val cryptoRepository: CryptoRepository) {

    fun loadDataFromNet(){
        cryptoRepository.loadDataFromNet()
    }
}