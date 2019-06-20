package com.giles.room.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

@Entity
class Acceptances{
    @SerializedName("id")
    var id : String? = null
    @SerializedName("employeeId")
    var employeeId : String? = null
    @PrimaryKey
    @NonNull
    @SerializedName("securityCode")
    var securityCode : String? = null
    @SerializedName("firstName")
    var firstName : String? = null
    @SerializedName("lastName")
    var lastName : String? = null
    @SerializedName("photoUrl")
    var photoUrl : String? = null
    @SerializedName("intId")
    var intId : Int = 0
}