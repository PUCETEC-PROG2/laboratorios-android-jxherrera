package ec.edu.puce.githubclient.sevices

import ec.edu.puce.githubclient.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_USER="https://api.github.com"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor( interceptor = logging)
        .addInterceptor { chain ->
            val token = BuildConfig.GITHUB_TOKEN
            println("token: $token")

            val request = chain.request().newBuilder()
                .addHeader( name = "Authotization", value = "Bearer $token")
                .build()

            chain.proceed(request)
        }
        .build()

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_USER)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}