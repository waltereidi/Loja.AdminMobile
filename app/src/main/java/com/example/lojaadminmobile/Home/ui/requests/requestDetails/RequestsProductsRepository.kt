package com.example.lojaadminmobile.Home.ui.requests.requestDetails

import com.google.gson.annotations.SerializedName

data class RequestsProductsRepository(
    @SerializedName("name") val name:String,
    @SerializedName("imageUrl") val productImageUrl:String,
    @SerializedName("sku") val sku:String ,
    @SerializedName("ean") val ean:String ,
    @SerializedName("price") val price:Double ,
    @SerializedName("quantity") val quantity:Int

)

