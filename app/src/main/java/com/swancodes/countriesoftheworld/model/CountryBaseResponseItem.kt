package com.swancodes.countriesoftheworld.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryBaseResponseItem(
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val independent: Boolean = true,
    val landlocked: Boolean?,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val unMember: Boolean
) : Parcelable