package com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ProductDetailRepository(
    @SerializedName("name") val name:String,
    @SerializedName("description") val description:String,
    @SerializedName("sku") val sku:String,
    @SerializedName("ean") val ean:String,
    @SerializedName("imageUrl") val imageUrl:String,
    @SerializedName("category") val category:String,
    @SerializedName("created_at") val updatedAt: Date,
    @SerializedName("updated_at") val createdAt: Date,
    @SerializedName("id") val id:Int,
 )