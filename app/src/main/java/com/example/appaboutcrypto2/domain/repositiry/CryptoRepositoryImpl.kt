package com.example.appaboutcrypto2.domain.repositiry

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.appaboutcrypto2.data.database.CryptoDatabase
import com.example.appaboutcrypto2.data.maper.CryptoMaper
import com.example.appaboutcrypto2.domain.model.CryptoItem

class CryptoRepositoryImpl (private val apll: Application):CryptoRepository {

    private val cryptoDAO = CryptoDatabase.getInstance(apll).cryptoDAO()


    override fun loadDataFromNet() {
        TODO("Not yet implemented")
    }


    override fun getDataFromDB(): LiveData<List<CryptoItem>> {
        return Transformations.map(cryptoDAO.getCryptoList()){ listDBType->
            listDBType.map {
                CryptoMaper.mapDBtypeToCryptoItem(it)
            }
        }
    }

    override suspend fun addItemToDB(cryptoItem: CryptoItem) {
        CryptoMaper.mapCryptoItemToDBtype(cryptoItem).also {
            cryptoDAO.addItemToCryptoList(it)
        }
    }
}