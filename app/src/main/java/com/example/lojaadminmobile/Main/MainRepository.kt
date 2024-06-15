package com.example.lojaadminmobile.Main

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import java.time.Clock

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
        @SerializedName("created_at") val CreatedAt:Clock,
        @SerializedName("expires_at") val ExpireAt:Clock
    )
    @IgnoreExtraProperties
    data class LoginDTO(val token: String, val email: String, val firstName:String , val lastName:String , val createdAt:Clock , val expireAt:Clock) {
    }
}