package com.ascstb.mangasc.di

import com.ascstb.mangasc.model.Provider
import org.koin.dsl.module

val myAppModule = module {
    factory { Provider.MANGATOWN }
}