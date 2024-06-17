package com.example.lojaadminmobile

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.lojaadminmobile.Main.MainViewModel
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun submitLoginTestIsUnsuccesfull() {
        //Tests execution of the method
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val main:MainViewModel = MainViewModel(appContext)
        val response = main.SubmitLogin("testCase@email.com" ,"123" )
        assert(!response)
    }
}