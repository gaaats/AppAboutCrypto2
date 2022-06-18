package com.example.appaboutcrypto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appaboutcrypto2.databinding.ActivityMainBinding
import com.example.appaboutcrypto2.presentation.CryptoListAdapter
import com.example.appaboutcrypto2.presentation.MainVievModel
import com.example.appaboutcrypto2.presentation.MainVievModelFactory

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        CryptoListAdapter()
    }
    private val  vievModel by lazy {
        ViewModelProvider(this, MainVievModelFactory(application))[MainVievModel::class.java]
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyckerContainer.adapter = adapter

        vievModel.cryptoList.observe(this){
            adapter.submitList(it)
        }

        binding.btnLoad.setOnClickListener {
            vievModel.addItem()
        }
    }

}