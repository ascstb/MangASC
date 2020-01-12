package com.ascstb.mangasc.core

import android.app.Application
import com.ascstb.mangasc.BuildConfig
import com.ascstb.mangasc.di.myAppModule
import com.ascstb.mangasc.di.repository.apiModule
import com.ascstb.mangasc.di.repository.mangaTownModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            if (BuildConfig.DEBUG) androidLogger()
            androidContext(this@MyApp)
            modules(
                myAppModule,
                apiModule,
                mangaTownModule
            )
        }
    }
}