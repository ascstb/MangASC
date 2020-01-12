package com.ascstb.mangasc.repository.remote

import com.ascstb.mangasc.model.Manga
import com.ascstb.mangasc.model.Provider
import com.ascstb.mangasc.repository.ApiResult
import com.ascstb.mangasc.repository.remote.provider.mangatown.MangaTownProvider
import kotlinx.coroutines.Deferred

class MangaProviderImpl(
    private val provider: Provider,
    private val mangaTownProvider: MangaTownProvider
) : MangaProvider {
    override fun getLatestPageAsync(page: Int): Deferred<ApiResult<List<Manga>>> = when (provider) {
        Provider.MANGATOWN -> mangaTownProvider.getLatestPageAsync(page)
        //else -> mangaTownProvider.getLatestPageAsync(page)
    }
}