package com.example.lojaadminmobile.Home.ui.requests.RequestDetails.ui.theme

import com.google.gson.annotations.SerializedName

data class RequestDetailRepository(
    @SerializedName("id") val id:Int,
    @SerializedName("itensCount") val itensCount:String,
    @SerializedName("total") val total:Double ,
    @SerializedName("clientName") val clientName:String,
    @SerializedName("address") val address:String ,
    @SerializedName("requestId") val requestId:Int
 )