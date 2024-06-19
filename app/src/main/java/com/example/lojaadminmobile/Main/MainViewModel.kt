package com.example.lojaadminmobile.Main

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.database.getValue
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
    private val Db = FireBase(_context)
//this method should store the token and used login for future use
    fun SubmitLogin(email:String , password:String ,callBack: (Boolean) -> Unit)
    {
        val body = MainRepository.LoginRequest(email, password)
        val call = ApiService.submitLogin(body)

        call.enqueue(object : Callback<MainRepository.LoginResponse> {
            override fun onResponse(call: Call<MainRepository.LoginResponse>, response: Response<MainRepository.LoginResponse>) {
                if( response.isSuccessful()){
                    Db.SetAuthentication( response.body()!!)
                    Db.SetLogin(body)
                    callBack(true)
                }else{
                    Toast.makeText(_context, "Invalid email or password", Toast.LENGTH_SHORT).show()
                    callBack(false)
                }
            }
            override fun onFailure(call: Call<MainRepository.LoginResponse?>, t: Throwable)
            {
                Toast.makeText(_context, t.message , Toast.LENGTH_SHORT).show()
                callBack(false)
            }

        })
    }
    fun VerifyStoredLogin(callBack:(Boolean)->Unit)
    {
        Db.GetLogin().addOnSuccessListener {
            val storedLogin = it.getValue<MainRepository.LoginRequest>()
            this.SubmitLogin(storedLogin!!.email , storedLogin!!.password){
                callBack(it)
            }
        }
    }

}