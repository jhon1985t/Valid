package com.jhonjto.co.valid.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by jhon on 9/05/2020
 */
data class Image(
    @SerializedName("#text")
    val text: String,
    @SerializedName("size")
    val size: String
)