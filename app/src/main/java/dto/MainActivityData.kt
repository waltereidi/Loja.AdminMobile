package dto

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
public class MainActivityData{
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
    @IgnoreExtraProperties
    data class LoginDTO(val token: String? = null, val email: String? = null , val fisrtName:String? , val lastName:String? ) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }

}
