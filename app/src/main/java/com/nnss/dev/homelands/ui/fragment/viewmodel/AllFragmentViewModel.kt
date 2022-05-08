package com.nnss.dev.homelands.ui.fragment.viewmodel

import android.content.SharedPreferences
import com.nnss.dev.homelands.commons.base.BaseViewModel
import com.nnss.dev.homelands.commons.utils.ApiState
import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import com.nnss.dev.homelands.domain.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AllFragmentViewModel(
    private val repository: MainRepository
) :
    BaseViewModel() {

    val state = MutableStateFlow(ApiState(listOf(RestCountriesResponse())))

    fun getAllCountries() = launch {
        repository.getAllCountries()
            .collect {
                state.value = it
            }
    }
}

