package com.swancodes.countriesoftheworld.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.data.network.CountriesApiClient
import com.swancodes.countriesoftheworld.databinding.FragmentCountriesBinding
import com.swancodes.countriesoftheworld.model.CountryBaseResponseItem
import com.swancodes.countriesoftheworld.ui.FilterBottomSheetFragment
import com.swancodes.countriesoftheworld.ui.LanguageBottomSheetFragment
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

        binding.switchTheme.setOnClickListener {

            val nightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when (nightMode) {
                Configuration.UI_MODE_NIGHT_YES -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

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
                ) { // Checking for the response
                    val dataModel = response.body()
                    setUpRecyclerViewAdapter(dataModel)
                    binding.statusImage.visibility = View.GONE
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(
                    call: Call<List<CountryBaseResponseItem>>,
                    t: Throwable
                ) {
                    binding.statusImage.setImageResource(R.drawable.ic_error)
                }
                //Toast.makeText(requireContext(), "Failure", Toast.LENGTH_SHORT).show()
            })
    }

    fun setUpRecyclerViewAdapter(items: List<CountryBaseResponseItem>?) {
        //items?.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.name.common })
        val countriesAdapter = CountriesAdapter(object : CountriesAdapter.CountriesItemClickListener {
                override fun onItemClick(item: CountryBaseResponseItem?) {
                    item?.let {
                        val directions = CountriesFragmentDirections.toDetailsFragment(it)
                        findNavController().navigate(directions)
                    }
                }
            })
        items?.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.name.common })
        binding.recyclerView.adapter = countriesAdapter
        countriesAdapter.setCountryList(items)
    }
}