package com.swancodes.countriesoftheworld.data.network

import com.swancodes.countriesoftheworld.model.CountryBaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface CountriesApiService {
    @GET("v3.1/all")
    fun getCountriesData(): Call<CountryBaseResponse>
}
