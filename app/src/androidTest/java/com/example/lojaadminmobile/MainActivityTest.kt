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
    private val viewModel: MainViewModel = MainViewModel(InstrumentationRegistry.getInstrumentation().targetContext)
    @Test
    fun submitLoginTestIsUnsuccesfull() {
        //Tests execution of the method
        viewModel.SubmitLogin("testCase@email.com" ,"123" ){
            assert(!it)
        }
    }
    @Test
    fun VerifyStoedLoginDoesNotBreakApplication()
    {
        //Assert unsuccesfull login returns false
        viewModel.VerifyStoredLogin(){
            assert(it)
        }
    }
}