package com.example.gamesystest.remote.model

data class CountryResponse(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val name: String,
    val region: String,
    val topLevelDomain: List<String>
)