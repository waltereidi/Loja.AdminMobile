package di

import android.content.Context
import com.example.lojaadminmobile.Main.MainRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

class FireBase(_context: Context) {
    private val Db = DependencyInjection().GetFireBaseInstance(_context)
    fun SetAuthentication(login: MainRepository.LoginResponse) : Task<Void> = Db
        .child("Authentication")
        .child("auth")
        .setValue(login)
    fun GetAuthentication() : Task<DataSnapshot> = Db
        .child("Authentication")
        .child("auth")
        .get()


}