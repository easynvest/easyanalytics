package com.easynvest.analytics

import java.io.Serializable

data class Event(
    val name: String?,
    val params: MutableMap<String, Any?>? = null
) : Serializable