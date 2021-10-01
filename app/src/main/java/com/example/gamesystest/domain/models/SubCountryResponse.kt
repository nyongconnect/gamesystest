package com.example.gamesystest.domain.models

class SubCountryResponseDomain : ArrayList<SubCountryResponseItemDomain>()

data class SubCountryResponseItemDomain(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Int,
    val borders: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val currencies: List<Currency>,
    val demonym: String,
    val flag: String,
    val gini: Double,
    val languages: List<Language>,
    val latlng: List<Int>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val regionalBlocs: List<RegionalBloc>,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
    val translations: Translations
)

data class Currency(
    val code: String,
    val name: String,
    val symbol: String
)

data class Language(
    val iso639_1: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
)

data class RegionalBloc(
    val acronym: String,
    val name: String
)

data class Translations(
    val br: String,
    val de: String,
    val es: String,
    val fa: String,
    val fr: String,
    val hr: String,
    val `it`: String,
    val ja: String,
    val nl: String,
    val pt: String
)