package com.giles.room.ui.main

import com.giles.room.api.ApiService
import com.giles.room.data.db.ClockDao
import com.giles.room.data.db.DeviceEmployeeDao
import com.giles.room.data.db.DeviceLoginDao
import com.giles.room.data.model.ClockData
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepository{
    private val apiService: ApiService
    private val deviceLoginDao: DeviceLoginDao
    private val deviceEmployeeDao : DeviceEmployeeDao
    private val clockDao : ClockDao

    @Inject
    constructor(apiService: ApiService, deviceLoginDao: DeviceLoginDao, deviceEmployeeDao: DeviceEmployeeDao, clockDao: ClockDao) {
        this.apiService = apiService
        this.deviceLoginDao = deviceLoginDao
        this.deviceEmployeeDao = deviceEmployeeDao
        this.clockDao = clockDao
    }

    fun saveClockData(clockData: ClockData?) : Flowable<Long>{
        return Flowable.fromCallable { clockDao?.insertClockData(clockData) }.subscribeOn(Schedulers.io())
    }

    fun getClockData() : Flowable<Array<ClockData>>{
        return clockDao?.getClockData().subscribeOn(Schedulers.io())
    }

}