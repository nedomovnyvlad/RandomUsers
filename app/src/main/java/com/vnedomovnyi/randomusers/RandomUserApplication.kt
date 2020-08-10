package com.vnedomovnyi.randomusers

import android.app.Application
import com.vnedomovnyi.randomusers.data.remote.dataModule
import com.vnedomovnyi.randomusers.data.remote.remoteModule
import com.vnedomovnyi.randomusers.domain.interactorModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class RandomUserApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@RandomUserApplication)
            modules(MODULES)
        }
    }

    companion object {
        private val MODULES = listOf(
            dataModule,
            interactorModule,
            remoteModule
        )
    }

}