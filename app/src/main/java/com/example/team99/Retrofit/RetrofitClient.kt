package com.example.team99.Retrofit

import com.example.team99.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    private fun getRetrofit():Retrofit{

        val gson = GsonBuilder().setLenient().create()

        val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
        }).addInterceptor {

            //Request
            val request = it.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer $token")
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
        fun apiService(): Retrofit_interface{
            return getRetrofit().create(Retrofit_interface::class.java)
        }
}