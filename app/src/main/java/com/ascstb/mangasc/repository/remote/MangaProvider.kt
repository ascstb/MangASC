package com.ascstb.mangasc.repository.remote

import com.ascstb.mangasc.model.Manga
import com.ascstb.mangasc.repository.ApiResult
import kotlinx.coroutines.Deferred

interface MangaProvider {
    fun getLatestPageAsync(page: Int): Deferred<ApiResult<List<Manga>>>
}