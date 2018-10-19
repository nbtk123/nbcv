package com.nbtk.nbcv.experience.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nbtk.nbcv.experience.R
import com.nbtk.nbcv.experience.model.TimelineItem
import com.nbtk.nbcv.experience.model.TimelineItemData
import com.nbtk.nbcv.experience.model.TimelineItemHeader
import com.nbtk.nbcv.experience.view.rvholders.TimelineDataRVHolder
import com.nbtk.nbcv.experience.view.rvholders.TimelineHeaderRVHolder
import com.nbtk.nbcv.experience.view.rvholders.TimelineRVHolderBase


class ExperiencesRvAdapter : RecyclerView.Adapter<TimelineRVHolderBase>() {

    companion object {
        val ITEM_VIEW_TYPE_DATA = 0
        val ITEM_VIEW_TYPE_HEADER = 1
        val ITEM_VIEW_TYPE_UNKNOWN = -1
    }

    val timelineItems = listOf<TimelineItem>()

    override fun getItemViewType(position: Int): Int {
        return when(timelineItems.get(position)) {
            is TimelineItemHeader -> ITEM_VIEW_TYPE_HEADER
            is TimelineItemData -> ITEM_VIEW_TYPE_DATA
            else -> ITEM_VIEW_TYPE_UNKNOWN
        }
    }

    override fun getItemCount(): Int {
        return timelineItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineRVHolderBase {
        return when (viewType) {
            ITEM_VIEW_TYPE_DATA -> createTimelineDataViewHolder(parent)
            ITEM_VIEW_TYPE_HEADER -> createTimelineHeaderViewHolder(parent)
            else -> throw Exception("Unknown item type!")
        }
    }

    private fun createTimelineHeaderViewHolder(parent: ViewGroup): TimelineRVHolderBase {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.timeline_item_header, parent, false)
        return TimelineHeaderRVHolder(itemView)
    }

    private fun createTimelineDataViewHolder(parent: ViewGroup): TimelineRVHolderBase {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.timeline_item_data, parent, false)
        return TimelineHeaderRVHolder(itemView)
    }

    override fun onBindViewHolder(holder: TimelineRVHolderBase, position: Int) {
        when (getItemViewType(position)) {
            ITEM_VIEW_TYPE_DATA -> bindTimelineDataViewHolder(holder, position)
            ITEM_VIEW_TYPE_HEADER -> bindTimelineHeaderViewHolder(holder, position)
            else -> throw Exception("Unknown item type!")
        }
    }

    private fun bindTimelineHeaderViewHolder(holder: TimelineRVHolderBase, position: Int) {
        val headerRVHolder = holder as TimelineHeaderRVHolder
        val item = (timelineItems.get(position) as TimelineItemHeader)
        headerRVHolder.tvTimelineItemHeaderText.text = item.text
    }

    private fun bindTimelineDataViewHolder(holder: TimelineRVHolderBase, position: Int) {
        val dataRVHolder = holder as TimelineDataRVHolder
        val item = (timelineItems.get(position) as TimelineItemData)
        dataRVHolder.tvTimelineItemDataTitle.text = item.title
        dataRVHolder.tvTimelineItemDataDescription.text = item.description
        Glide.with(holder.itemView.context).load(item.logoUrl).into(dataRVHolder.ivTimelineItemDataLogo)
    }

}