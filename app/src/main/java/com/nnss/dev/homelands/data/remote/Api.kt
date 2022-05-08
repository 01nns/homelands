package com.nnss.dev.homelands.data.remote

import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("all")
    suspend fun getAllCountries(): Response<ArrayList<RestCountriesResponse>>
}