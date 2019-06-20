package com.giles.room.data.model

import com.google.gson.annotations.SerializedName

class ClockResponse{
    @SerializedName("status")
    var status : String? = null
    @SerializedName("error")
    var error : ErrorData? = null
}