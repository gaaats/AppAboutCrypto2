package com.example.appaboutcrypto2.di

import android.app.Application
import com.example.appaboutcrypto2.data.CryptoRepositoryImpl
import com.example.appaboutcrypto2.data.database.CryptoDAO
import com.example.appaboutcrypto2.data.database.CryptoDatabase
import com.example.appaboutcrypto2.domain.repositiry.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    fun bindRepository_to_RepositoryImpl(impl: CryptoRepositoryImpl): CryptoRepository

    companion object {
        @Provides
        fun provideShopingListDAO(
            application: Application
        ): CryptoDAO {
            return CryptoDatabase.getInstance(application).cryptoDAO()
        }
    }
}