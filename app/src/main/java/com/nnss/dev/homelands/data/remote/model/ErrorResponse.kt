package com.nnss.dev.homelands.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("message")
    @Expose
    val message: String? = null

    @SerializedName("_links")
    @Expose
    val links: Links? = null
}

class Links {
    @SerializedName("self")
    @Expose
    val self: Self? = null
}

class Self {
    @SerializedName("href")
    @Expose
    val href: String? = null

    @SerializedName("templated")
    @Expose
    val templated: Boolean? = null
}