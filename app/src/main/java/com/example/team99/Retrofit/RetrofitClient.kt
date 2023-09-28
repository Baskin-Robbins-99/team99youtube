package com.example.team99.Retrofit

import com.example.team99.BuildConfig
import com.example.team99.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private fun getRetrofit():Retrofit{
        val token: String = ""

        val gson = GsonBuilder().setLenient().create()

        val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
        }).addInterceptor {

            //Request
            val request = it.request()
                .newBuilder()
                .addHeader("Authorization","Bearer $token")
                .build()

            //Response
            val response = it.proceed(request)
            response
        }.build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }


//        fun apiService(): Retrofit_interface{
//            return getRetrofit().create(Retrofit_interface::class.java)
//        }
    val apiService : Retrofit_interface by lazy {
    getRetrofit().create(Retrofit_interface::class.java)
}
//    private fun createOkHttpClient(): OkHttpClient {
//        val interceptor = HttpLoggingInterceptor()
//
//        if (BuildConfig.DEBUG)
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//        else
//            interceptor.level = HttpLoggingInterceptor.Level.NONE
//
//        return OkHttpClient.Builder()
//            .connectTimeout(20, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .addNetworkInterceptor(interceptor)
//            .build()
//    }
}