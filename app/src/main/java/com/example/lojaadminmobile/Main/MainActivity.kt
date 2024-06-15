package com.example.lojaadminmobile.Main

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.lojaadminmobile.R

class MainActivity : ComponentActivity() {
    private val email: EditText get() = findViewById(R.id.emailEdit)
    private val password: EditText get() = findViewById(R.id.passwordEdit)
    private val viewModel:MainViewModel get() = MainViewModel(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }
    fun submitLogin(view: View) {
        viewModel.SubmitLogin(email.text.toString() , password.text.toString())
    }

}





