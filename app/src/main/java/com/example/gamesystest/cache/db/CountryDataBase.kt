package com.example.gamesystest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gamesystest.cache.dao.CountryDao
import com.example.gamesystest.cache.typeconverter.CountryLocal


@Database(
        entities = [CountryLocal::class],
        version = 1,
        exportSchema = false
)
abstract class CountryDataBase : RoomDatabase(){
    abstract fun countryDao(): CountryDao
}

