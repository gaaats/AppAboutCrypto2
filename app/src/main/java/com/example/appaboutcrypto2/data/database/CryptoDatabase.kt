package com.example.appaboutcrypto2.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [CryptoItemDBType::class], version = 2, exportSchema = false)
abstract class CryptoDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: CryptoDatabase? = null
        private const val DB_NAME = "cryptoMain.db"
        private val LOCK = Any()

        val migration_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE crypto_table ADD COLUMN lastUpdate TEXT DEFAULT ''")
            }
        }


        fun getInstance(application: Application): CryptoDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    application.applicationContext,
                    CryptoDatabase::class.java,
                    DB_NAME
                )
                    .addMigrations(migration_1_2)
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }


//            synchronized(LOCK) {
//                INSTANCE?.let { return it }
//                val instance =
//                    Room.databaseBuilder(
//                        context,
//                        CryptoDatabase::class.java,
//                        DB_NAME
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                INSTANCE = instance
//                return instance
//            }
        }
    }

    abstract fun cryptoDAO(): CryptoDAO
}