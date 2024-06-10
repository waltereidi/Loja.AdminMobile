package dto

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("Email") val email:String,
    @SerializedName("Password") val password:String
)
data class LoginResponse(
    @SerializedName("token") val Token:String,
    @SerializedName("email") val Email:String,
    @SerializedName("firstName") val FirstName:String,
    @SerializedName("lastName") val LastName:String,
)
