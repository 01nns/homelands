package com.nnss.dev.homelands.commons.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.google.gson.GsonBuilder
import com.nnss.dev.homelands.data.remote.model.ErrorResponse
import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

fun <T> toResultFlow(call: suspend () -> Response<T>?): Flow<ApiState<T>> {
    return flow {
        emit(ApiState.loading())

        try {
            val c = call()
            c?.let {
                kotlinx.coroutines.delay(2000)
                if (c.isSuccessful) {
                    emit(ApiState.success(c.body()))
                } else {
                    c.errorBody()?.let { errBody ->
                        val gson = GsonBuilder().create()
                        var resp: ErrorResponse? = null

                        try {
                            resp = gson.fromJson(errBody.string(), ErrorResponse::class.java)
                        } catch (e: IOException) {
                            e.message?.let { Timber.e(it) }
                        }
                        emit(ApiState.error<Nothing>(resp?.message))
                    }
                }
            }
        } catch (e: Exception) {
            emit(ApiState.error<Nothing>(e.message))
        }

    }.flowOn(Dispatchers.IO)
}

inline fun Fragment.observeFlows(crossinline observationFunction: suspend (CoroutineScope) -> Unit) {
    viewLifecycleOwner.lifecycle.coroutineScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            observationFunction(this)
        }
    }
}

inline fun <T> Flow<T>.collectLA(
    owner: LifecycleOwner,
    crossinline onCollect: suspend (T) -> Unit
) = owner.lifecycleScope.launch { owner.repeatOnLifecycle(Lifecycle.State.STARTED) { collect { onCollect(it) } } }

inline fun <T> Flow<T>.collectLatestLA(
    owner: LifecycleOwner,
    crossinline onCollect: suspend (T) -> Unit
) = owner.lifecycleScope.launch { owner.repeatOnLifecycle(Lifecycle.State.STARTED) { collectLatest { onCollect(it) } } }
