package com.giles.room.data.model

import com.google.gson.annotations.SerializedName

class DeviceEmployees{
    @SerializedName("status")
    var status : String? = null
    @SerializedName("data")
    var data : DeviceEmployeesData? = null
}