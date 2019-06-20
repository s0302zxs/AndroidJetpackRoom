package com.giles.room.data.model

import com.google.gson.annotations.SerializedName

class DeviceIdentitiesData{
    @SerializedName("employees")
    var employees : ArrayList<Employees>? = null
//    @SerializedName("visitors")
//    var visitors : ArrayList<Visitors>? = null
}