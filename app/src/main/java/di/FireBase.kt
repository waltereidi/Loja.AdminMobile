package di

import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

class FireBase(_context: Context) {
    private val Db = DependencyInjection().GetFireBaseInstance(_context)
    fun SetAuthentication(loginResponse: MainRepository.LoginResponse) : Task<Void> = Db
        .child("Authentication")
        .child("auth")
        .setValue(loginResponse)

    fun GetAuthentication() : Task<DataSnapshot> = Db.child("Authentication").child("auth").get()

    fun SetLogin(login:MainRepository.LoginRequest) : Task<Void> = Db
        .child("Authentication")
        .child("login")
        .setValue(login)

    fun GetLogin() : Task<DataSnapshot> = Db.child("Authentication").child("login").get()
    fun Test() : Task<DataSnapshot> = Db.child("test").child("test").get()





}