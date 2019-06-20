package com.giles.room.data.db

import android.arch.persistence.room.TypeConverter
import com.giles.room.data.model.ModulesModes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



object RoomTypeConverters{
    @TypeConverter
    @JvmStatic
    fun fromString(data: String?): ArrayList<ModulesModes>? {
        var gson = Gson()
        val listType = object : TypeToken<ArrayList<ModulesModes>>() {
        }.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromArrayList(modulesModes: ArrayList<ModulesModes>?): String? {
        var gson = Gson()
        return gson.toJson(modulesModes)
    }
}