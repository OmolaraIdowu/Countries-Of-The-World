package com.swancodes.countriesoftheworld.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.swancodes.countriesoftheworld.adapters.CountriesAdapter
import com.swancodes.countriesoftheworld.data.network.CountriesApiClient
import com.swancodes.countriesoftheworld.databinding.FragmentCountriesBinding
import com.swancodes.countriesoftheworld.model.CountryBaseResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCountriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.languageButton.setOnClickListener {
            val bottomSheet = LanguageBottomSheetFragment()
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            fragmentManager.let { bottomSheet.show(it, LanguageBottomSheetFragment.TAG) }
        }
        binding.filterButton.setOnClickListener {
            val bottom = FilterBottomSheetFragment()
            val fragment = (activity as FragmentActivity).supportFragmentManager
            fragment.let {
                bottom.show(it, FilterBottomSheetFragment.TAG)
            }
        }

        CountriesApiClient.retrofitService.getCountriesData()
            .enqueue(object : Callback<List<CountryBaseResponseItem>> {
                override fun onResponse(
                    call: Call<List<CountryBaseResponseItem>>,
                    response: Response<List<CountryBaseResponseItem>>
                ) {
                    // Checking for the response
                    val dataModel = response.body()
                    setUpRecyclerViewAdapter(dataModel)
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(
                    call: Call<List<CountryBaseResponseItem>>,
                    t: Throwable
                ) {
                    Toast.makeText(requireContext(), "Failure", Toast.LENGTH_SHORT).show()
                }
            })
    }
    fun setUpRecyclerViewAdapter(items: List<CountryBaseResponseItem>?) {
        val countriesAdapter: CountriesAdapter = CountriesAdapter()
        binding.recyclerView.adapter = countriesAdapter
        countriesAdapter.setCountryList(items)

        //val directions = CountriesFragmentDirections.toDetailsFragment()
        //findNavController().navigate(directions)
    }
}