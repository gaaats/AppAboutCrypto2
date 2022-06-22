package com.example.appaboutcrypto2.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.appaboutcrypto2.data.database.CryptoDatabase
import com.example.appaboutcrypto2.data.maper.CryptoMaper
import com.example.appaboutcrypto2.data.net.ApiFactory
import com.example.appaboutcrypto2.data.net.model.NetModel
import com.example.appaboutcrypto2.data.vorkers.UpdateDatabaseWorker
import com.example.appaboutcrypto2.domain.model.CryptoItem
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository
import retrofit2.Response

class CryptoRepositoryImpl (private val application: Application): CryptoRepository {

    private val cryptoDAO = CryptoDatabase.getInstance(application).cryptoDAO()

    init {
//        cryptoDAO.addItemToCryptoList(CryptoItemDBType(0,"kkk", 666.0, "frgt"))
    }

    override suspend fun loadDataFromNet() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            UpdateDatabaseWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            UpdateDatabaseWorker.makeRequest()
        )
//        val result = ApiFactory.apiService.getTopCoinsInfo()
//        if (result.isSuccessful){
//            result.body()?.let {
//                it.Data.forEach {
//                    CryptoMaper.mapFromNetModelToDataBAse(it).also {
//                        cryptoDAO.addItemToCryptoList(it)
//                        Log.d("loadDataFromNet", "goood")
//                    }
//                }
//            }
//        }
//        else{
//            Log.d("loadDataFromNet", "bed")
//        }

//        return ApiFactory.apiService.getTopCoinsInfo()
    }



    override fun getDataFromDB(): LiveData<List<CryptoItem>> {
        return Transformations.map(cryptoDAO.getCryptoList()){ listDBType->
            listDBType.map {
                CryptoMaper.mapDBtypeToCryptoItem(it)
            }
        }
    }

    override fun addItemToDB(cryptoItem: CryptoItem) {
        CryptoMaper.mapCryptoItemToDBtype(cryptoItem).also {
            cryptoDAO.addItemToCryptoList(it)
        }
    }
}