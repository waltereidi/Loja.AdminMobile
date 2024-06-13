package com.example.lojaadminmobile.Main

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lojaadminmobile.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import di.DependencyInjection
import dto.MainActivityData
import dto.MainActivityData.LoginRequest
import dto.MainActivityData.LoginResponse
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
    fun createViewModel(): ViewModelProvider.Companion {

        val i = "i"
        //val factory = MainViewModelFactory( activity?.application!!)

        return ViewModelProvider
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
                    val res = response.body()
                    val login = MainActivityData.LoginDTO(
                        res?.Token,
                        res?.Email,
                        res?.FirstName,
                        res?.LastName
                    )

                    database.child("Authentication").child("auth").setValue(login)

                    database.child("Authentication").child("auth").get().addOnSuccessListener {
                        val i = it
                    }.addOnFailureListener{
                        val u = it
                    }

                }
                override fun onFailure(call: Call<LoginResponse?>, t: Throwable)
                {
                }
            })
        }catch (e:Exception)
        {
            val ex = e;
        }
    }
}





