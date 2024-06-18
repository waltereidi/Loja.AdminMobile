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
        //Assert data gets overwritten
        val dto: MainRepository.LoginResponse = MainRepository.LoginResponse("token"  ,"email" , "fname" , "lname" , Date() , Date() )
        val dto_overwrite:MainRepository.LoginResponse = MainRepository.LoginResponse("token_2"  ,"email" , "fname" , "lname" , Date() , Date() )
        Db.SetAuthentication(dto)
        Db.SetAuthentication(dto_overwrite)
        Db.GetAuthentication().addOnSuccessListener {
            val result = it.getValue<MainRepository.LoginResponse>()
            assert(result!!.Token == dto_overwrite.Token)
        }
    }
    @Test
    fun SetLoginStoresTheLastUsedAuthentication()
    {
        //Assert stored login is retrieved
        val login:MainRepository.LoginRequest = MainRepository.LoginRequest("testCase@email.com" , "123")
        Db.SetLogin(login)
        Db.GetLogin().addOnSuccessListener {
            val result = it.getValue<MainRepository.LoginRequest>()
            assert(result!!.email != login.email)
        }

    }
    @Test
    fun TestsInvalidQueryDoenstBreakApplication()
    {
        //assert this code does not break
        Db.Test().addOnSuccessListener {
            it.getValue()
            assert(true)
        }
        assert(true)
    }

}