package com.giles.room.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName
import com.giles.room.data.db.RoomTypeConverters

@Entity
@TypeConverters(RoomTypeConverters::class)
class DeviceLoginData{
    @PrimaryKey
    @NonNull
    @SerializedName("deviceToken")
    var deviceToken : String? = null
    @SerializedName("locale")
    var locale : String? = null
    @SerializedName("deviceName")
    var deviceName : String? = null
    @SerializedName("modulesModes")
    var modulesModes : ArrayList<ModulesModes>? = null
}