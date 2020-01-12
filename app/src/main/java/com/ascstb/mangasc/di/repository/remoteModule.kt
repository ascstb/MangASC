package com.ascstb.mangasc.di.repository

import com.ascstb.mangasc.BuildConfig
import com.ascstb.mangasc.repository.createOkHttpClient
import com.ascstb.mangasc.repository.createWebService
import com.ascstb.mangasc.repository.remote.MangaProvider
import com.ascstb.mangasc.repository.remote.MangaProviderImpl
import com.ascstb.mangasc.repository.remote.provider.mangatown.MangaTownApi
import com.ascstb.mangasc.repository.remote.provider.mangatown.MangaTownProvider
import com.ascstb.mangasc.repository.remote.provider.mangatown.MangaTownProviderImpl
import org.koin.dsl.module

val apiModule = module {
    single { createOkHttpClient() }
}

val mangaTownModule = module {
    single<MangaTownApi> { createWebService(get(), BuildConfig.MANGATOWN_SERVER) }
    single<MangaTownProvider> { MangaTownProviderImpl(get()) }
}

val serviceModule = module {
    single<MangaProvider>{MangaProviderImpl(get(), get())}
}


val remoteModule = listOf(
    apiModule,
    mangaTownModule
)