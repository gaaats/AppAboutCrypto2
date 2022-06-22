package com.example.appaboutcrypto2.data.vorkers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.appaboutcrypto2.data.database.CryptoDatabase
import com.example.appaboutcrypto2.data.maper.CryptoMaper
import com.example.appaboutcrypto2.data.net.ApiFactory
import kotlinx.coroutines.delay


class UpdateDatabaseWorker(context: Context, parameters: WorkerParameters) :
    CoroutineWorker(context, parameters) {

    private val cryptoDAO = CryptoDatabase.getInstance(context).cryptoDAO()

    override suspend fun doWork(): Result {
        while (true) {
            try {
                loadDataFromNet()

            } catch (e: Exception) {
            }
            delay(10000)
        }
    }

    private suspend fun loadDataFromNet() {
        val result = ApiFactory.apiService.getTopCoinsInfo()
        if (result.isSuccessful) {
            result.body()?.let {
                it.Data.forEach {
                    CryptoMaper.mapFromNetModelToDataBAse(it).also {
                        cryptoDAO.addItemToCryptoList(it)
                        Log.d("loadDataFromNet", "goood")
                    }
                }
            }
        } else {
            Log.d("loadDataFromNet", "bed")
        }
    }
    companion object{
        const val WORKER_NAME = "UpdateDatabaseWorker"

        fun makeRequest():OneTimeWorkRequest{
            return OneTimeWorkRequestBuilder<UpdateDatabaseWorker>().build()
        }
    }
}