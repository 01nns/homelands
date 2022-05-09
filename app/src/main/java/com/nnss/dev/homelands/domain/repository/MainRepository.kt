package com.nnss.dev.homelands.domain.repository

import com.nnss.dev.homelands.commons.utils.ApiState
import com.nnss.dev.homelands.commons.utils.toResultFlow
import com.nnss.dev.homelands.data.remote.Api
import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getAllCountries() : Flow<ApiState<ArrayList<RestCountriesResponse>>>
    fun getCountryByName(name: String?) : Flow<ApiState<ArrayList<RestCountriesResponse>>>
}

class MainRepositoryImpl(private val api: Api) : MainRepository {
    override fun getAllCountries(): Flow<ApiState<ArrayList<RestCountriesResponse>>> {
        return toResultFlow {
            api.getAllCountries()
        }
    }

    override fun getCountryByName(name: String?): Flow<ApiState<ArrayList<RestCountriesResponse>>> {
        return toResultFlow {
            api.getCountryByName(name)
        }
    }

}