package com.example.gamesystest.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val name: String,
    val region: String,
    val topLevelDomain: List<String>
): Parcelable