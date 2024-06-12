package com.example.lojaadminmobile

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
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
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


    }
    fun submitLogin(view: View) {
        try{
            FirebaseApp.initializeApp(this)

            database = Firebase.database.reference
            val body = LoginRequest(email.text.toString(), password.text.toString())
            var call =apiService.submitLogin(body)
            call?.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(call: Call<LoginResponse?>, response: Response<LoginResponse?>)
                {
                    database.child("Authentication").child(response.body()!!.Email).setValue(response.body())

                    database.child("users").child(response.body()!!.Email).get().addOnSuccessListener {
                        val i = it.value
                    }.addOnFailureListener{

                    }

                    TODO("Not yet implemented")
                }
                override fun onFailure(call: Call<LoginResponse?>, t: Throwable)
                {
                    TODO("Not yet implemented")
                }
            })
        }catch (e:Exception)
        {
            val ex = e;
        }
    }
}





