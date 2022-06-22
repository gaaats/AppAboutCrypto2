package com.example.appaboutcrypto2.domain

import com.example.appaboutcrypto2.data.net.model.NetModel
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository
import retrofit2.Response

class LoadDataFromNet(private val cryptoRepository: CryptoRepository) {

    suspend fun loadDataFromNet() {
        return cryptoRepository.loadDataFromNet()
    }
}