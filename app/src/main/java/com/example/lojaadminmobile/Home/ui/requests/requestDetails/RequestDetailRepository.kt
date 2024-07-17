package com.example.lojaadminmobile.Home.ui.requests.requestDetails

import com.google.gson.annotations.SerializedName

public data class RequestDetailRepository(
    @SerializedName("id") val id:Int,
    @SerializedName("itensCount") val itensCount:String,
    @SerializedName("total") val total:Double ,
    @SerializedName("clientName") val clientName:String,
    @SerializedName("address") val address:String ,
    @SerializedName("requestId") val requestId:Int,
    @SerializedName("email") val email:String
 )