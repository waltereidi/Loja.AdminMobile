package com.example.lojaadminmobile
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import di.DependencyInjection
import dto.LoginRequest
import dto.LoginResponse
import interfaces.IMainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private val email: EditText get() = findViewById(R.id.emailEdit)
    private val password: EditText get() = findViewById(R.id.passwordEdit)
    private val apiService =  DependencyInjection().GetRetrofit().create(IMainActivity::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }
    fun submitLogin(view: View) {
        try{
            val body = LoginRequest(email.text.toString(), password.text.toString())
            var call =apiService.submitLogin(body)
            call?.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(
                    call: Call<LoginResponse?>,
                    response: Response<LoginResponse?>
                ) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
        }catch (e:Exception)
        {
            val ex = e;
        }
    }
}





