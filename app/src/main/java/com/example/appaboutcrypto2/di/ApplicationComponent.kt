package com.example.appaboutcrypto2.di

import android.app.Application
import com.example.appaboutcrypto2.MainActivity
import dagger.BindsInstance
import dagger.Component


@Component(modules = [VievModelModules::class, DataModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}




