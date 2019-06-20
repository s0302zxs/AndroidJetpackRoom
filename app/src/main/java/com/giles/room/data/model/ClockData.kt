package com.giles.room.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

@Entity
class ClockData{
    @SerializedName("deviceToken")
    var deviceToken : String = ""
    //no use
    @SerializedName("serial")
    var serial : Int = 0
    @SerializedName("id")
    var id : String? = null
    @SerializedName("securityCode")
    var securityCode : String? = null
    @SerializedName("type")
    var type : String? = null
    @SerializedName("faceImg")
    var faceImg : String? = null
    @SerializedName("faceVerify")
    var faceVerify : String? = null
    @PrimaryKey
    @NonNull
    @SerializedName("deviceTime")
    var deviceTime : String? = null
    @SerializedName("clockType")
    var clockType : String? = null
    @SerializedName("liveness")
    var liveness : String? = null
    @SerializedName("mode")
    var mode : Int = 0
    @SerializedName("module")
    var module : Int = 0
    @SerializedName("rfid")
    var rfid : String? = null
    @SerializedName("recordMode")
    var recordMode : String? = null

    @SerializedName("isVisitorOpenDoor")
    var isVisitorOpenDoor : Boolean = false
    @SerializedName("isEmployeeOpenDoor")
    var isEmployeeOpenDoor : Boolean? = false

    @SerializedName("firstName")
    var firstName : String? = null
    @SerializedName("lastName")
    var lastName : String? = null
    @SerializedName("intId")
    var intId : Int = 0
}