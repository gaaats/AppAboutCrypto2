package com.example.appaboutcrypto2.di

import androidx.lifecycle.ViewModel
import com.example.appaboutcrypto2.presentation.MainVievModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface VievModelModules {

    @Binds
    @IntoMap
    @VievModelKeyAnnotation(MainVievModel::class)
    fun bindViewModelSingleItem(impl: MainVievModel):ViewModel

}