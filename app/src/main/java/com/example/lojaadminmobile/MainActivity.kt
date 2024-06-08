package com.example.lojaadminmobile
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    private val retrofit = Retrofit.Builder().baseUrl("https://192.168.0.108:7179")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService = retrofit.create(AuthenticationApi::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    fun submitLogin(view: View) {
        try{
            val body = LoginRequest(email.text.toString(), password.text.toString())
            var call =apiService.submitLogin(body)
            call?.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(call: Call<LoginResponse?>?, response: Response<LoginResponse?>) {
                    val myItem =response.body()
                }

                override fun onFailure(call: Call<LoginResponse?>?, t: Throwable?) {
                    var error = t
                }
            })
        }catch (e:Exception)
        {
            val ex = e;
        }
    }

}




interface AuthenticationApi {
    @POST("/api/Admin/Authentication/Login")
    fun submitLogin(@Body body:LoginRequest): Call<LoginResponse?>?

}