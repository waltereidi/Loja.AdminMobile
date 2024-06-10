package interfaces
import dto.LoginRequest
import dto.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IMainActivity {
    @POST("/api/Admin/Authentication/Login")
    fun submitLogin(@Body body: LoginRequest): Call<LoginResponse?>?
}