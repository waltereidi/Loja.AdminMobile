package com.example.lojaadminmobile.Main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import com.example.lojaadminmobile.Home.HomeActivity
import com.example.lojaadminmobile.R

class MainActivity : ComponentActivity() {
    private val progressBar: ProgressBar get() = findViewById<ProgressBar>(R.id.main_progressBar)
    private val email: EditText get() = findViewById(R.id.emailEdit)
    private val password: EditText get() = findViewById(R.id.passwordEdit)
    private val viewModel:MainViewModel get() = MainViewModel(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.VerifyStoredLogin(){
            if(it){
                val intent = Intent(this , HomeActivity::class.java )

                startActivity(intent)
            }

        }

    }
    fun submitLogin(view: View) {
        progressBar.progress = 10;
        progressBar.progress = 20;
        progressBar.progress = 30;
        progressBar.progress = 40;
        progressBar.progress = 50;
        progressBar.progress = 60;
        progressBar.progress = 70;
        progressBar.progress = 80;
        progressBar.progress = 90;
        progressBar.progress = 100;
        val intent = Intent(this , HomeActivity::class.java )

        startActivity(intent)
//        viewModel.SubmitLogin(email.text.toString() , password.text.toString()){
//            if(it)
//                Intent(this , HomeActivity::class.java )
//        }
    }

}





