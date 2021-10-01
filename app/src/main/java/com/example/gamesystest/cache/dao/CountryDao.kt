package com.example.gamesystest.cache.dao

import androidx.room.*
import com.example.gamesystest.cache.typeconverter.CountryLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCountriesToDb(countryLocal: List<CountryLocal>)

    @Query("SELECT * FROM countries")
    suspend fun getCountriesFromDb(): List<CountryLocal>

}