package com.nnss.dev.homelands.commons

import android.content.SharedPreferences
import android.media.MediaDrm
import com.nnss.dev.homelands.commons.utils.PreferenceHelper
import com.nnss.dev.homelands.commons.utils.USER_ID
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.util.*

fun commons() = module {
    fun provideUserId(sharedPreferences: SharedPreferences) : String? {
        val wideVineUUID = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
        val serialNumber = sharedPreferences.getString(USER_ID,"")
        return if (serialNumber.isNullOrEmpty()) {
            try {
                val id =
                    MediaDrm(wideVineUUID).getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)
                val regex = "[^a-zA-Z0-9]".toRegex()
                UUID.nameUUIDFromBytes(id).toString().replace(regex, "").uppercase()

            } catch (e: Exception) {
                // Inspect exception
                null
            }
        } else {
            serialNumber
        }
    }

    single { PreferenceHelper.customPrefs(androidContext(), "homelands") }

    single { provideUserId(get()) }
}