package com.ascstb.mangasc.repository.remote.provider.mangatown.response

import androidx.annotation.Keep
import pl.droidsonroids.jspoon.annotation.Selector

@Keep
class LatestResponse {
    @Selector(".post-list > li")
    var mangaList: List<MangaResponse> = listOf()

    inner class MangaResponse {
        @Selector("div.post > a > div.post-info > p.title")
        var title: String = ""

        @Selector("div.post > a.manga-cover > img", attr = "src")
        var coverUrl: String = ""

        @Selector("div.post > a.manga-cover", attr = "href")
        var url: String = ""

        @Selector("div.post > a.read-btn")
        var latestChapter: String = ""

        @Selector("div.post > a.read-btn", attr = "href")
        var latestChapterUrl: String = ""
    }
}