package com.giles.room.data.model

import com.google.gson.annotations.SerializedName

class DeviceRecordsData{
    @SerializedName("deviceToken")
    var deviceToken : String? = null

    @SerializedName("records")
    var records : ArrayList<ClockData>? = null
}