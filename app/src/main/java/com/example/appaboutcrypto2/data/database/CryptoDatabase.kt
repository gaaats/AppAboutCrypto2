package com.example.appaboutcrypto2.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class CryptoDatabase : RoomDatabase() {
    companion object {

        private var db: CryptoDatabase? = null
        private const val DB_NAME = "cryptoMain.db"
        private val LOCK = Any()

        fun getInstance(context: Context): CryptoDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        CryptoDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun cryptoDAO(): CryptoDAO
}