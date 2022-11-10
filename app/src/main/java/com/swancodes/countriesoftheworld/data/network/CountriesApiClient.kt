package com.swancodes.countriesoftheworld.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CountriesApiClient {

    private const val BASE_URL = "https://restcountries.com/"

    private val loggingInterceptor = HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).callTimeout(30L, TimeUnit.SECONDS)
        .connectTimeout(30L, TimeUnit.SECONDS).build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: CountriesApiService by lazy { retrofit.create(CountriesApiService::class.java) }

}