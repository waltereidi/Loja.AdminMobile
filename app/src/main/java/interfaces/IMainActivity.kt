package interfaces
import dto.MainActivityData.LoginRequest
import dto.MainActivityData.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IMainActivity {
    @POST("/api/Admin/Authentication/Login")
    fun     submitLogin(@Body body: LoginRequest): Call<LoginResponse?>?
}