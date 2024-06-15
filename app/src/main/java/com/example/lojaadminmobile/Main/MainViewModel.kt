package com.example.lojaadminmobile.Main

import android.content.Context
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
        var call =ApiService.submitLogin(body)
        call?.enqueue(object : Callback<MainRepository.LoginResponse?> {
            override fun onResponse(call: Call<MainRepository.LoginResponse?>, response: Response<MainRepository.LoginResponse?>)
            {
                val res = response.body()
                val login = MainRepository.LoginDTO( res?.Token, res?.Email, res?.FirstName, res?.LastName )
                FireBase.InsertAuthenticationFromLogin(login);
            }
            override fun onFailure(call: Call<MainRepository.LoginResponse?>, t: Throwable)
            {
            }
        })
    }

}