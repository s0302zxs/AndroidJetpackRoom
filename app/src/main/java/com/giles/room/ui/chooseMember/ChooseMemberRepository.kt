package com.giles.room.ui.chooseMember

import com.giles.room.api.ApiService
import com.giles.room.data.db.DeviceLoginDao
import javax.inject.Inject

class ChooseMemberRepository{
    private val apiService: ApiService
    private val deviceLoginDao: DeviceLoginDao

    @Inject
    constructor(apiService: ApiService, deviceLoginDao: DeviceLoginDao) {
        this.apiService = apiService
        this.deviceLoginDao = deviceLoginDao
    }

}