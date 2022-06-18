package com.example.appaboutcrypto2.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.appaboutcrypto2.domain.model.CryptoItem

class CryptoItemDiffCallback: DiffUtil.ItemCallback<CryptoItem>() {
    override fun areItemsTheSame(oldItem: CryptoItem, newItem: CryptoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CryptoItem, newItem: CryptoItem): Boolean {
        return oldItem == newItem
    }
}