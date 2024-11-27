package com.example.kmp
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



object RetrofitClient {

    private const val BASE_URL= "https://api.sampleapis.com/";

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}