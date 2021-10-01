package com.example.gamesystest.remote.api

import com.example.gamesystest.remote.model.CountryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryApi {

    @GET("all")
    suspend fun getAllCountries(
        @Query("access_key") apiKey: String): List<CountryResponse>
}