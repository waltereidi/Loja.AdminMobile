package di

import android.content.Context
import com.example.lojaadminmobile.Main.MainRepository

class FireBase(_context: Context) {
    private val Db  =   DependencyInjection().GetFireBaseInstance(_context)
    fun InsertAuthenticationFromLogin(login: MainRepository.LoginDTO)
    {

    }

}