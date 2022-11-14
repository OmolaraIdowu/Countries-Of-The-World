package com.swancodes.countriesoftheworld.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.databinding.CountryListItemsBinding
import com.swancodes.countriesoftheworld.model.CountryBaseResponseItem
import com.swancodes.countriesoftheworld.utils.loadImage

class CountriesAdapter(private val itemClickListener: CountriesItemClickListener) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {
    private var items: List<CountryBaseResponseItem>? = null

    fun setCountryList(countryList: List<CountryBaseResponseItem>?) {
        items = countryList
    }

    inner class CountriesViewHolder(private val binding: CountryListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(countryItem: CountryBaseResponseItem?) {
            binding.title.text = countryItem?.name?.common
            countryItem?.capital?.let {
                binding.capital.text = if (it.isNotEmpty()) {
                    it[0]
                } else {
                    ""
                }
            }
            binding.flagImage.loadImage(countryItem?.flags?.png)
            binding.root.setOnClickListener {
                itemClickListener.onItemClick(countryItem)
                binding.flagImage.loadImage(countryItem?.flags?.png)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_items, parent, false)
        return CountriesViewHolder(CountryListItemsBinding.bind(adapterLayout))
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(items?.get(position))
    }

    override fun getItemCount() = items?.size ?: 0

    interface CountriesItemClickListener {
        fun onItemClick(item: CountryBaseResponseItem?)
    }
}
