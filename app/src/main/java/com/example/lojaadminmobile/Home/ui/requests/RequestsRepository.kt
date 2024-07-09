package com.example.lojaadminmobile.Home.ui.requests

import com.google.gson.annotations.SerializedName
import java.util.Date

data class RequestsRepository(
    @SerializedName("imageUrl") val imageUrl:String,
    @SerializedName("clientName") val clientName:String,
    @SerializedName("id") val  id:Int ,
    @SerializedName("requestDescription") val description:String ,
    @SerializedName("requestStatus") val date:Date
)

