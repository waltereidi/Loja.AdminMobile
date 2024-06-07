package com.example.lojaadminmobile
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

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

class MainActivity : ComponentActivity() {
    private val email: EditText get() = findViewById(R.id.emailEdit)
    private val password: EditText get() = findViewById(R.id.passwordEdit)
    private val retrofit = Retrofit.Builder().baseUrl("https://localhost:7179/").build()
    private val apiService = retrofit.create(AuthenticationApi::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    fun submitLogin(view: View) {
        try{
            val body = LoginRequest(email.text.toString(), password.text.toString())
            apiService.submitLogin(body)
        }catch (e:Exception)
        {
            val ex = e;
        }
    }

}


interface AuthenticationApi {
    @POST("api/Admin/Authentication/Login")
    fun submitLogin(@Body body:LoginRequest): Call<LoginResponse?>?

}