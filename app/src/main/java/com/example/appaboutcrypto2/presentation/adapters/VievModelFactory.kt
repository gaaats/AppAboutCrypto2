package com.example.appaboutcrypto2.presentation.adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class VievModelFactory @Inject constructor(
    private val viewModelsMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelsMap[modelClass]?.get() as T
    }
}
