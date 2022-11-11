package com.swancodes.countriesoftheworld.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countries = args.countries
        binding.bodyText.text = countries.population.toString()

    }
}