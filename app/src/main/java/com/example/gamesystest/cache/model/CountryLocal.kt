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
    @field:TypeConverters(FieldIdTypeConverter::class)
    val callingCodes: List<String>,
    val capital: String,
    val name: String,
    val region: String,
    @field:TypeConverters(FieldIdTypeConverter::class)
    val topLevelDomain: List<String>,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)