package com.giles.room.ui.securityCode

import com.giles.room.api.ApiService
import com.giles.room.data.db.DeviceEmployeeDao
import io.reactivex.Flowable
import javax.inject.Inject

class SecurityCodeRepository{
    private val apiService: ApiService
    private val deviceEmployeeDao : DeviceEmployeeDao

    @Inject
    constructor(apiService: ApiService, deviceEmployeeDao: DeviceEmployeeDao) {
        this.apiService = apiService
        this.deviceEmployeeDao = deviceEmployeeDao
    }

    fun verify(securityCode : String?) : Flowable<Boolean> {
        return deviceEmployeeDao?.searchDeviceEmployeeBySecurityCode(securityCode)
    }


}