package com.ascstb.mangasc.repository.remote.provider.mangatown

import com.ascstb.mangasc.repository.remote.provider.mangatown.response.LatestResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaTownApi {
    @GET("latest/{page}.html")
    fun getLatestPageAsync(@Path("page") page: Int): Deferred<LatestResponse>
}