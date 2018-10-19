package com.nbtk.nbcv.experience.model

import java.util.*

abstract class TimelineItem(
        open val date: Date
)

data class TimelineItemHeader(
        override val date: Date,
        val text: String
) : TimelineItem(date)

data class TimelineItemData(
        override val date: Date,
        val title: String,
        val description: String,
        val logoUrl: String
) : TimelineItem(date)