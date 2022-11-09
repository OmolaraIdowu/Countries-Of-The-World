package com.swancodes.countriesoftheworld.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountriesApiClient {

    private const val BASE_URL = "https://restcountries.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: CountriesApiService by lazy { retrofit.create(CountriesApiService::class.java) }

}