package com.example.appaboutcrypto2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.appaboutcrypto2.domain.AddItemToDB
import com.example.appaboutcrypto2.domain.GetDataFromDB
import com.example.appaboutcrypto2.domain.model.CryptoItem
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepositoryImpl
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random

class MainVievModel( application: Application) : AndroidViewModel(application) {

    private val cryptoRepositoryImpl = CryptoRepositoryImpl(application)

    private val addItemToDB = AddItemToDB(cryptoRepositoryImpl)
    private val getDataFromDB = GetDataFromDB(cryptoRepositoryImpl)


    private val _cryptoList = getDataFromDB.getDataFromDB()
    val cryptoList: LiveData<List<CryptoItem>>
        get() = _cryptoList

    init {
        addItemToDB
    }

    fun addItem() {
        val element =
            CryptoItem(
                0,
                "lol ${Random.nextInt(10, 100)}",
                Random.nextDouble(100.0, 500.0),
                "hhhh"
            )

        viewModelScope.launch {
            addItemToDB.addItemToDB(element)
        }
    }

}