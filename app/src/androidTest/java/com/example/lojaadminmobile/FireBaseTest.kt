package com.example.lojaadminmobile

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.lojaadminmobile.Main.MainRepository
import com.google.firebase.database.getValue
import di.FireBase
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class FireBaseTest {

    private val Db: FireBase = FireBase(InstrumentationRegistry.getInstrumentation().targetContext)
    @Test
    fun SetAuthenticationReturnsTheSameValuesOnGet()
    {
        //Tests that the data inserted from tests returns equally
        val dto:MainRepository.LoginResponse = MainRepository.LoginResponse("token"  ,"email" , "fname" , "lname" , Date() , Date() )

        Db.SetAuthentication(dto)
        Db.GetAuthentication().addOnSuccessListener {
            val result = it.getValue<MainRepository.LoginResponse>()
            assert(result!!.Token == dto.Token)
        }
    }

}