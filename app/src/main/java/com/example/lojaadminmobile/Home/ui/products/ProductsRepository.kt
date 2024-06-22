package com.example.lojaadminmobile.Home.ui.products

import com.google.gson.annotations.SerializedName

class ProductsRepository {
    data class Products(
        @SerializedName("name") val name:String,
        @SerializedName("description") val description:String,
        @SerializedName("sku") val sku:String ,
        @SerializedName("ean") val ean:String ,
        @SerializedName("imageUrl") val imageUrl:String ,
        @SerializedName("category") val category:String
    )


}