package com.ascstb.mangasc.repository.remote.provider.mangatown

import com.ascstb.mangasc.model.Manga
import com.ascstb.mangasc.repository.ApiResult
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import timber.log.Timber

class MangaTownProviderImpl(
    private val api: MangaTownApi
) : MangaTownProvider {
    private val cachedMangas = mutableMapOf<Int, List<Manga>>()

    override fun getLatestPageAsync(page: Int): Deferred<ApiResult<List<Manga>>> = GlobalScope.async {
        try {
            ApiResult.Ok(
                api.getLatestPageAsync(page).await().mangaList
                    .map {
                    Manga(
                        title = it.title,
                        coverUrl = it.coverUrl,
                        src = it.coverUrl,
                        latestChapter = it.latestChapter,
                        latestChapterSrc = it.latestChapterUrl
                    )
                }
                    .run {
                    cachedMangas[page] = this
                    this
                }
            )
        } catch (e: Exception) {
            Timber.d("MangaTownProviderImpl_TAG: getLatestPageAsync: exception: ${e.message}")
            ApiResult.Error(e)
        }
    }
}