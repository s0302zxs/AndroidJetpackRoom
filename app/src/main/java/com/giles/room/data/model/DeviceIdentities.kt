package com.giles.room.data.model

import com.google.gson.annotations.SerializedName

class DeviceIdentities{
    @SerializedName("status")
    var status : String? = null
    @SerializedName("data")
    var data : DeviceIdentitiesData? = null
}