package com.example.appaboutcrypto2.data.maper

import com.example.appaboutcrypto2.data.database.CryptoItemDBType
import com.example.appaboutcrypto2.domain.model.CryptoItem

object CryptoMaper {

    fun mapCryptoItemToDBtype(cryptoItem: CryptoItem): CryptoItemDBType{
        //change ImageUrl
        return CryptoItemDBType(0, cryptoItem.name, cryptoItem.price, cryptoItem.ImageUrl)
    }

    fun mapDBtypeToCryptoItem(cryptoItemDBType: CryptoItemDBType):CryptoItem{
        return CryptoItem(cryptoItemDBType.id, cryptoItemDBType.name, cryptoItemDBType.inUsd, cryptoItemDBType.ImageUrl)
    }
}