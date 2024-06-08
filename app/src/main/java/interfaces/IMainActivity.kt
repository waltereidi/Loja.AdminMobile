package interfaces
import dto.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
interface AuthenticationApi {
    @POST("/api/Admin/Authentication/Login")
    fun submitLogin(@Body body: LoginRequest): Call<Void>?

}