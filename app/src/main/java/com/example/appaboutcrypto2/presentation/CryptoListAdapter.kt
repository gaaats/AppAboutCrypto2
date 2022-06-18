package com.example.appaboutcrypto2.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.appaboutcrypto2.R
import com.example.appaboutcrypto2.domain.model.CryptoItem

class CryptoListAdapter :
    ListAdapter<CryptoItem, CryptoRecyclerViewViewHolder>(CryptoItemDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CryptoRecyclerViewViewHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_for_recycler_crypto, parent, false).also {
                return CryptoRecyclerViewViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: CryptoRecyclerViewViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            tvName.text = currentItem.name
            tvPrice.text = currentItem.price.toString()
            img.setImageResource(R.drawable.monetization)
            img.load(currentItem.ImageUrl){
                placeholder(R.drawable.monetization)
            }
            tvTime.text = currentItem.lastUpdate
        }
    }
}