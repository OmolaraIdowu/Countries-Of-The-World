package com.swancodes.countriesoftheworld.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.data.network.CountriesApiClient
import com.swancodes.countriesoftheworld.databinding.FragmentCountriesBinding
import com.swancodes.countriesoftheworld.model.CountryBaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCountriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CountriesApiClient.retrofitService.getCountriesData().enqueue(object : Callback<CountryBaseResponse> {
            override fun onResponse(call: Call<CountryBaseResponse>, response: Response<CountryBaseResponse>) {

            }

            override fun onFailure(call: Call<CountryBaseResponse>, t: Throwable) {

            }
        })

    }
}