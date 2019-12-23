package com.easynvest.analytics

interface Tracker {
    fun onEvent(event: Event)
    fun onUserProperty(property: UserProperty)
    fun onUserId(userId: String)
    fun onScreen(screenName: ScreenName)
}