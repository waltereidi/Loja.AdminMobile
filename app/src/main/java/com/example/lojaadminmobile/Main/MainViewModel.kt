package com.example.lojaadminmobile.Main

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import di.DependencyInjection
import di.FireBase
import interfaces.IMainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class MainViewModel(context:Context) : ViewModel()
{
    private var _context:Context
    init { this._context = context }
    private val ApiService =  DependencyInjection().GetRetrofit(null).create(IMainActivity::class.java)
    private val FireBase = FireBase(_context)

    fun SubmitLogin(email:String , password:String )
    {
        val body = MainRepository.LoginRequest(email, password)
        val call = ApiService.submitLogin(body)

        call.enqueue(object : Callback<MainRepository.LoginResponse> {
            override fun onResponse(call: Call<MainRepository.LoginResponse>, response: Response<MainRepository.LoginResponse>)
            {
                if(response.isSuccessful()){
                    FireBase.SetAuthentication( response.body()!!);
                }else{
                    Toast.makeText(_context, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<MainRepository.LoginResponse?>, t: Throwable)
            {
                Toast.makeText(_context, t.message , Toast.LENGTH_SHORT).show()
            }
        })
    }

}