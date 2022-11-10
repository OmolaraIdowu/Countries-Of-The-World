package com.swancodes.countriesoftheworld.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.swancodes.countriesoftheworld.data.network.CountriesApiClient
import com.swancodes.countriesoftheworld.databinding.FragmentCountriesBinding
import com.swancodes.countriesoftheworld.model.CountryBaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesFragment : BottomSheetDialogFragment() {

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

        binding.languageButton.setOnClickListener {
            val bottomSheet = BottomFragment()
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            fragmentManager.let { bottomSheet.show(it, BottomFragment.TAG) }

            CountriesApiClient.retrofitService.getCountriesData()
                .enqueue(object : Callback<CountryBaseResponse> {
                    override fun onResponse(
                        call: Call<CountryBaseResponse>,
                        response: Response<CountryBaseResponse>
                    ) {

                    }

                    override fun onFailure(call: Call<CountryBaseResponse>, t: Throwable) {
                        Log.d("MainActivity", "onFailure: " + t.message)
                    }
                })
        }
    }
}