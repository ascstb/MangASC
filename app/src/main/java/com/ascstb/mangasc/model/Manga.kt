package com.ascstb.mangasc.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Manga(
    val title: String,
    val coverUrl: String?,
    val src: String?,
    val latestChapter: String?,
    val latestChapterSrc: String?
) : Parcelable