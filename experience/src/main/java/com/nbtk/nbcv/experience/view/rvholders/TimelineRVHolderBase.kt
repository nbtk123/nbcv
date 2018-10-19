package com.nbtk.nbcv.experience.view.rvholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nbtk.nbcv.experience.R

abstract class TimelineRVHolderBase(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class TimelineHeaderRVHolder(itemView: View) : TimelineRVHolderBase(itemView) {
    val tvTimelineItemHeaderText = itemView.findViewById<TextView>(R.id.tvTimelineItemHeaderText)
}

class TimelineDataRVHolder(itemView: View) : TimelineRVHolderBase(itemView) {
    val tvTimelineItemDataTitle = itemView.findViewById<TextView>(R.id.tvTimelineItemDataTitle)
    val tvTimelineItemDataDescription = itemView.findViewById<TextView>(R.id.tvTimelineItemDataDescription)
    val ivTimelineItemDataLogo = itemView.findViewById<ImageView>(R.id.ivTimelineItemDataLogo)
}