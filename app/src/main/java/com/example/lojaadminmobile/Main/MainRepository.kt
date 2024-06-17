package com.example.lojaadminmobile.Main

import com.google.gson.annotations.SerializedName
import java.util.Date

class MainRepository {
    data class LoginRequest(
        @SerializedName("Email") val email:String,
        @SerializedName("Password") val password:String
    )
    data class LoginResponse(
        @SerializedName("token") val Token:String,
        @SerializedName("email") val Email:String,
        @SerializedName("firstName") val FirstName:String,
        @SerializedName("lastName") val LastName:String,
        @SerializedName("created_at") val CreatedAt:Date,
        @SerializedName("expires_at") val ExpireAt: Date
    )
}