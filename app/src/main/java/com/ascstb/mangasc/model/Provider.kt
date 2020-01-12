package com.ascstb.mangasc.model

enum class Provider (
    val mangaProviderId: Int,
    val description: String
) {
    MANGATOWN(
        mangaProviderId = 1,
        description = "MangaTown"
    )
}