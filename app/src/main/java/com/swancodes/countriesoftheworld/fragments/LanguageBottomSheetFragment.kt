package com.swancodes.countriesoftheworld.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.databinding.FragmentLanguageBottomSheetBinding

class LanguageBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentLanguageBottomSheetBinding

    override fun getTheme(): Int = R.style.BottomSheetDailogTheme

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLanguageBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.closeButton.setOnClickListener{
            dialog?.dismiss()
        }
    }
    companion object {
        const val TAG = "SelectLanguages"
    }
}
