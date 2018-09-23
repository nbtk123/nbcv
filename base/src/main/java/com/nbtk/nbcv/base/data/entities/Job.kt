package com.nbtk.nbcv.base.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nbtk.nbcv.base.data.entities.Job.Companion.TABLE_NAME
import java.util.*

@Entity(tableName=TABLE_NAME)
data class Job(
        @PrimaryKey(autoGenerate=true) var id: Long?,
        @ColumnInfo(name= COL_NAME) var name: String,
        @ColumnInfo(name=COL_DESCRIPTION) var description: String,
        @ColumnInfo(name=COL_LOGO_URL) var logoUrl: String,
        @ColumnInfo(name=COL_START_DATE) var startDate: Date,
        @ColumnInfo(name=COL_END_DATE) var endDate: Date,
        @ColumnInfo(name=COL_SKILLS) var skills: List<String>,
        @ColumnInfo(name=COL_PRODUCT_URL) var productUrl: String
) {
    companion object {
        const val TABLE_NAME: String = "Jobs"
        const val COL_NAME: String =  "name"
        const val COL_DESCRIPTION = "description"
        const val COL_LOGO_URL = "logoUrl"
        const val COL_START_DATE = "startDate"
        const val COL_END_DATE = "endDate"
        const val COL_SKILLS = "skills"
        const val COL_PRODUCT_URL = "productUrl"

    }
}