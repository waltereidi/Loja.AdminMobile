package dto

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("Email") val email:String,
    @SerializedName("Password") val password:String
)
data class LoginResponse(
    val Token:String,
    val Email:String,
    val FirstName:String,
    val LastName:String,
)
