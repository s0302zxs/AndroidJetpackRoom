package com.giles.room.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.giles.room.data.model.Acceptances
import io.reactivex.Flowable


@Dao
abstract class DeviceEmployeeDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertDeviceEmployeeData(deviceLoginData: Acceptances?)


    @Query("SELECT CASE WHEN EXISTS(SELECT * FROM Acceptances WHERE securityCode = :securityCode) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END")
    abstract fun searchDeviceEmployeeBySecurityCode(securityCode: String?): Flowable<Boolean>

}