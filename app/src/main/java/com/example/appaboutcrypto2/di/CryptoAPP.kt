package com.example.appaboutcrypto2.di

import android.app.Application

class CryptoAPP : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}