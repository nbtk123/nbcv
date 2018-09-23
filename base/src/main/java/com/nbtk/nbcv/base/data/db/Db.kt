package com.nbtk.nbcv.base.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nbtk.nbcv.base.application.CvApp
import com.nbtk.nbcv.base.data.dao.JobDao
import com.nbtk.nbcv.base.data.entities.Job
import com.nbtk.nbcv.base.data.typeconverters.Converters

@Database(entities = [(Job::class)], version = Db.VERSION)
@TypeConverters(Converters::class)
abstract class Db: RoomDatabase() {

    abstract fun jobDao(): JobDao

    companion object {
        const val VERSION = 1

        val instance: Db by lazy {
            Room.databaseBuilder(CvApp.appContext, Db::class.java, "db.db").build()
        }
    }
}