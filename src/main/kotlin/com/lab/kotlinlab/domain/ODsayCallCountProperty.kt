package com.lab.kotlinlab.domain

class ODsayCallCountProperty(
    var startX: String,
    var startY: String,
    var endX: String,
    var endY: String,
    var oDsayCallCount: Int,
    var routeCount: Int,
) : MixpanelEventProperty
