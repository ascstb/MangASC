package com.ascstb.mangasc.repository.remote.provider.mangatown

import com.ascstb.mangasc.model.Manga
import com.ascstb.mangasc.repository.ApiResult
import kotlinx.coroutines.Deferred

interface MangaTownProvider {
    fun getLatestPageAsync(page: Int): Deferred<ApiResult<List<Manga>>>
}