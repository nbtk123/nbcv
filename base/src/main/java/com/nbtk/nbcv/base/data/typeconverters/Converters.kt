package com.nbtk.nbcv.base.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

class Converters {

    val gson: Gson = Gson()

    @TypeConverter
    fun fromTimestampToDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDateToTimestamp(date: Date): Long? {
        return date.time
    }

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToList(str: String): List<String> {
        return gson.fromJson(str, object: TypeToken<ArrayList<String>>(){}.type)
    }
}