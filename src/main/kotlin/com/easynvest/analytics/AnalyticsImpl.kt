package com.easynvest.analytics

class AnalyticsImpl : Analytics {

    private val trackers: MutableList<Tracker> = mutableListOf()
    private var currentUserId: String = ""

    override fun trackEvent(event: Event?) {
        if (event != null && !event.name.isNullOrBlank()) {
            trackers.forEach { tracker ->
                tracker.onEvent(event)
            }
        }
    }

    override fun trackScreen(screen: ScreenName?) {
        if (screen != null && !screen.name.isNullOrBlank()) {
            trackers.forEach { tracker ->
                tracker.onScreen(screen)
            }
        }
    }

    override fun trackUserProperty(property: UserProperty) {
        trackers.forEach { tracker ->
            tracker.onUserProperty(property)
        }
    }

    override fun setUserId(userId: String) {
        currentUserId = userId
        trackers.forEach { tracker ->
            tracker.onUserId(userId)
        }
    }

    override fun addTracker(tracker: Tracker) {
        trackers += tracker
        if (currentUserId.isNotEmpty()) tracker.onUserId(currentUserId)
    }

    override fun removeTracker(tracker: Tracker) {
        trackers -= tracker
    }
}