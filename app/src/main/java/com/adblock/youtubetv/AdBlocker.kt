package com.adblock.youtubetv

/**
 * Simple domain-based ad blocker.
 * Checks outgoing WebView requests against a list of known
 * ad / tracking domains and blocks them before they load.
 */
object AdBlocker {

    // Known ad & tracking domains commonly used to serve video/display ads.
    private val blockedDomains = listOf(
        "doubleclick.net",
        "googlesyndication.com",
        "googleadservices.com",
        "google-analytics.com",
        "adservice.google.com",
        "pagead2.googlesyndication.com",
        "youtube.com/api/stats/ads",
        "youtube.com/pagead",
        "youtube.com/ptracking",
        "s.youtube.com",
        "static.doubleclick.net",
        "securepubads.g.doubleclick.net",
        "ad.doubleclick.net",
        "amazon-adsystem.com",
        "adnxs.com",
        "moatads.com",
        "scorecardresearch.com",
        "innovid.com",
        "2mdn.net",
        "googletagservices.com",
        "googletagmanager.com",
        "imasdk.googleapis.com"
    )

    fun isAd(url: String?): Boolean {
        if (url == null) return false
        val lower = url.lowercase()
        return blockedDomains.any { lower.contains(it) }
    }
}
