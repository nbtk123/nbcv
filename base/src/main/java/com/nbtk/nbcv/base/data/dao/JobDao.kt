package com.nbtk.nbcv.base.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.nbtk.nbcv.base.data.entities.Job

enum class OrderBy(val value: String) {
    START_DATE(Job.COL_START_DATE),
    END_DATE(Job.COL_END_DATE);

    override fun toString(): String {
        return value
    }
}

enum class Order {
    ASC, DESC
}

@Dao
interface JobDao {

    @Query(" SELECT * FROM ".plus(Job.TABLE_NAME).plus(" ORDER BY :orderBy :order"))
    fun getAllJobs(orderBy: OrderBy, order: Order): LiveData<List<Job>>
}