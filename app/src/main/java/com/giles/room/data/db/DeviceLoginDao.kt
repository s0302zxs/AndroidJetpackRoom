package com.giles.room.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.giles.room.data.model.DeviceLoginData
import io.reactivex.Flowable


@Dao
abstract class DeviceLoginDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertDeviceLoginData(deviceLoginData: DeviceLoginData?)

//    @Query("SELECT * FROM DeviceLoginData WHERE deviceToken = :deviceToken")
//    abstract fun getDeviceLoginData(deviceToken: String): LiveData<DeviceLoginData>

    @Query("SELECT * FROM DeviceLoginData WHERE deviceToken = :deviceToken")
    abstract fun getDeviceLoginData(deviceToken: String?): Flowable<DeviceLoginData>

}