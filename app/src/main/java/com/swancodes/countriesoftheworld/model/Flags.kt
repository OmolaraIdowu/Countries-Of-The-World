package com.swancodes.countriesoftheworld.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flags(
    @SerializedName("png")
    val png: String,
    val svg: String
) : Parcelable