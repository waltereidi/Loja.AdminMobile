package com.example.lojaadminmobile

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import retrofit2.http.GET
import retrofit2.http.POST

class MainActivity : ComponentActivity() {
    private val email: EditText get() = findViewById(R.id.emailEdit)
    private val password: EditText get() = findViewById(R.id.passwordEdit)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

    }
    private fun submit()
    {

    }

}

