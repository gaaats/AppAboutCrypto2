package com.example.appaboutcrypto2.data.maper

import com.example.appaboutcrypto2.data.Constance
import com.example.appaboutcrypto2.data.database.CryptoItemDBType
import com.example.appaboutcrypto2.data.net.model.Data
import com.example.appaboutcrypto2.domain.model.CryptoItem
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object CryptoMaper {

    fun mapCryptoItemToDBtype(cryptoItem: CryptoItem): CryptoItemDBType {
        //change ImageUrl
        var id = 0
        return CryptoItemDBType(id++, cryptoItem.name, cryptoItem.price, cryptoItem.ImageUrl,
            cryptoItem.lastUpdate
        )
    }

    fun mapDBtypeToCryptoItem(cryptoItemDBType: CryptoItemDBType): CryptoItem {
        return CryptoItem(
            cryptoItemDBType.id,
            cryptoItemDBType.name,
            cryptoItemDBType.inUsd,
            cryptoItemDBType.ImageUrl,
            cryptoItemDBType.lastUpdate
        )
    }

    fun mapFromNetModelToDataBAse(netModel: Data): CryptoItemDBType {
        return CryptoItemDBType(
            netModel.CoinInfo.Id.toInt(),
            netModel.CoinInfo.FullName,
            netModel.RAW.USD.PRICE,
            Constance.BASE_IMAGE_URL + netModel.CoinInfo.ImageUrl,
            convertTimestampToTime(netModel.RAW.USD.LASTUPDATE.toLong()),
        )
    }

    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }
}