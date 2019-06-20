package com.giles.room.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.giles.room.data.model.Acceptances
import com.giles.room.data.model.ClockData
import com.giles.room.data.model.DeviceLoginData

@Database(
    entities = [
        DeviceLoginData::class,
        Acceptances::class,
        ClockData::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDb: RoomDatabase(){
    abstract fun deviceLoginDao() : DeviceLoginDao
    abstract fun deviceEmployeeDao() : DeviceEmployeeDao
    abstract fun clockDao() : ClockDao


}