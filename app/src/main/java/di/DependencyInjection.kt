package di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


public  class DependencyInjection{
    private val ApiURL:String = "https://10.0.2.2:7179";
    private lateinit var database: DatabaseReference
    fun GetFireBaseInstance(_context: Context) :DatabaseReference
    {
        FirebaseApp.initializeApp(_context)
        return Firebase.database.reference
    }
    fun GetRetrofit(token:String?): Retrofit
    {

        return Retrofit
            .Builder()
            .baseUrl(ApiURL)
            //Creates the certificate for HTTPS API call
            .client(GetUnsafeOkHttpClient(token).build())
            //Converts the body to  JSON
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun GetUnsafeOkHttpClient(token:String?): OkHttpClient.Builder {
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }
            )
            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname, session -> true }
            //Create default headers bearer token if exists
//            builder.addInterceptor { chain ->
//                val request: Request =
//                    chain.request().newBuilder().addHeader("Authorization", "Bearer " ).build()
//                chain.proceed(request)
//            }
            return builder
        } catch (e: java.lang.Exception) {
            throw RuntimeException(e)
        }
    }
}