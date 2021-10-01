package com.example.gamesystest.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val currencies: List<Currency>,
    val demonym: String,
    val gini: Double,
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>
): Parcelable

@Parcelize
data class Currency(
    val code: String,
    val name: String,
    val symbol: String
): Parcelable