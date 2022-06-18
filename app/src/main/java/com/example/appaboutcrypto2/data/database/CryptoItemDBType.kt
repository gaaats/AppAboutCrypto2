package com.example.appaboutcrypto2.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "crypto_table")
data class CryptoItemDBType(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val inUsd: Double,
    val ImageUrl: String
)

