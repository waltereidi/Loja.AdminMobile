package com.example.lojaadminmobile

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private val viewModel:MainViewModel = MainViewModel(InstrumentationRegistry.getInstrumentation().targetContext)
    @Test
    fun submitLoginTestIsUnsuccesfull() {
        //Tests execution of the method
        val response = viewModel.SubmitLogin("testCase@email.com" ,"123" )
        assert(!response)
    }
    @Test
    fun VerifyStoedLoginDoesNotBreakApplication()
    {
        //Assert unsuccesfull login returns false
        val isSuccesfull =viewModel.VerifyStoredLogin()
        assert(!isSuccesfull)
    }
}