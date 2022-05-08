package com.nnss.dev.homelands.domain

import com.nnss.dev.homelands.data.remote.Api
import com.nnss.dev.homelands.domain.repository.MainRepository
import com.nnss.dev.homelands.domain.repository.MainRepositoryImpl
import com.nnss.dev.homelands.ui.fragment.viewmodel.AllFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun repository() = module {
    fun provideMainRepository(api: Api) : MainRepository {
        return MainRepositoryImpl(api)
    }

    single { provideMainRepository(get()) }
}

fun viewModel() = module {
    viewModel { AllFragmentViewModel(get()) }

}