package com.example.lojaadminmobile.Home.ui.products

import com.google.gson.annotations.SerializedName

data class ProductsRepository(
    @SerializedName("name") val name:String,
    @SerializedName("description") val description:String,
    @SerializedName("sku") val sku:String ,
    @SerializedName("ean") val ean:String ,
    @SerializedName("imageUrl") val imageUrl:String ,
    @SerializedName("category") val category:String
)

