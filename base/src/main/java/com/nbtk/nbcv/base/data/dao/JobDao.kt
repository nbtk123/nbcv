package com.nbtk.nbcv.base.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.nbtk.nbcv.base.data.entities.Job

@Dao
interface JobDao {
    @Query("SELECT * FROM ".plus(Job.TABLE_NAME))
    fun getAllJobs(): List<Job>
}