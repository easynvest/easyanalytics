package com.easynvest.analytics

interface Analytics {
    fun trackEvent(event: Event?)
    fun trackScreen(screen: ScreenName?)
    fun trackUserProperty(property: UserProperty)
    fun setUserId(userId: String)
    fun addTracker(tracker: Tracker)
    fun removeTracker(tracker: Tracker)
}