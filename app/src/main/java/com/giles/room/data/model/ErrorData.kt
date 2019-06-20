package com.giles.room.data.model

import com.google.gson.annotations.SerializedName

class ErrorData{
    @SerializedName("code")
    var code : String? = null
    @SerializedName("message")
    var message : String? = null
}