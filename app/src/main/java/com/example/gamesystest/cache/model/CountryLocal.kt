package com.example.gamesystest.cache.typeconverter

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(tableName = "countries")
data class CountryLocal(
    val alpha2Code: String,
    val alpha3Code: String,
    @field:TypeConverters(FieldIdTypeConverter::class)
    val altSpellings: List<String>,
    val area: Double,
    @field:TypeConverters(FieldIdTypeConverter::class)
    val borders: List<String>,
    @field:TypeConverters(FieldIdTypeConverter::class)
    val callingCodes: List<String>,
    val capital: String,
    @field:TypeConverters(DataTypeConverter::class)
    val currencies: List<CurrencyLocal>,
    val demonym: String,
    val gini: Double,
    @field:TypeConverters(NumberTypeConverter::class)
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val subregion: String,
    @field:TypeConverters(FieldIdTypeConverter::class)
    val timezones: List<String>,
    @field:TypeConverters(FieldIdTypeConverter::class)
    val topLevelDomain: List<String>,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)

data class CurrencyLocal(
    val code: String,
    val name: String,
    val symbol: String
)