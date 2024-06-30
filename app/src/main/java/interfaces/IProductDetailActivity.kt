package interfaces

import com.example.lojaadminmobile.Home.ui.requests.RequestDetails.ui.theme.RequestDetailRepository
import retrofit2.Call
import retrofit2.http.GET


public interface IProductDetailActivity {
    @GET("/api/Mobile/Products/GetProducts/{id}")
    fun getProducts(): Call<RequestDetailRepository>



}