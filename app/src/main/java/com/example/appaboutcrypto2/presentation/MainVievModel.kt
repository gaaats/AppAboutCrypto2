package com.example.appaboutcrypto2.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.appaboutcrypto2.domain.AddItemToDB
import com.example.appaboutcrypto2.domain.GetDataFromDB
import com.example.appaboutcrypto2.domain.model.CryptoItem
import com.example.appaboutcrypto2.data.CryptoRepositoryImpl
import com.example.appaboutcrypto2.data.database.CryptoDatabase
import com.example.appaboutcrypto2.data.net.model.NetModel
import com.example.appaboutcrypto2.domain.LoadDataFromNet
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.random.Random

class MainVievModel(application: Application) : AndroidViewModel(application) {

    private val cryptoDAO = CryptoDatabase.getInstance(application).cryptoDAO()


    private val cryptoRepositoryImpl = CryptoRepositoryImpl(application)

    private val addItemToDB = AddItemToDB(cryptoRepositoryImpl)
    private val getDataFromDB = GetDataFromDB(cryptoRepositoryImpl)
    private val loadDataFromNet = LoadDataFromNet(cryptoRepositoryImpl)

    private var _myResponse = MutableLiveData<Response<NetModel>>()
    val myResponse: LiveData<Response<NetModel>>
        get() = _myResponse


    var cryptoList = getDataFromDB.getDataFromDB() as MutableLiveData<List<CryptoItem>>

    init {
        loadDataFromNEt()
    }

    fun addItem() {
        val element =
            CryptoItem(
                0,
                "lol ${Random.nextInt(10, 100)}",
                Random.nextDouble(100.0, 500.0),
                "hhhh",
                ""
            )
        addItemToDB.addItemToDB(element)
    }

    fun deleteItem() {
        cryptoDAO.deleteAllUsers()
    }

    fun loadDataFromNEt() {
        viewModelScope.launch {
            loadDataFromNet.loadDataFromNet()
//            if (result.isSuccessful){
//                Log.d("nettt", "yeeees")
//                result.body()?.let {
//                    it.Data.forEach {
//                        Log.d("nettt", "From net: ${it.CoinInfo.FullName}")
//                        Log.d("nettt", "____________________________")
//                    }
//                }
//            } else{
//                Log.d("nettt", "nooooooooooooooooooooooooooooooo")
//            }
////             _myResponse.value = result
//        }
        }

    }
}