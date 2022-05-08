package com.nnss.dev.homelands.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nnss.dev.homelands.commons.utils.NetworkUtils
import com.nnss.dev.homelands.data.remote.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Nirson Nino Samson 05/08/2022.
 *
 * Data Module Injection
 */

fun data(baseUrl: String, isDebug: Boolean) = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .followSslRedirects(true)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()

                // for offline request that we caching
                if (NetworkUtils.hasInternet(androidContext())) {
                    request.addHeader("Cache-Control", "public, max-age=" + 1)
                } else {
                    request.addHeader(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                    )
                }
                chain.proceed(request.build())
            }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (isDebug)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            })
            //.addInterceptor(AuthInterceptor(tokenType = "Bearer", accessToken = "*********"))
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    factory { get<Retrofit>().create(Api::class.java) }
}