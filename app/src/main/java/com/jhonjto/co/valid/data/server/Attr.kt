package com.jhonjto.co.valid.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by jhon on 9/05/2020
 */
data class Attr(
    @SerializedName("country")
    val country: String,
    @SerializedName("page")
    val page: String,
    @SerializedName("perPage")
    val perPage: String,
    @SerializedName("total")
    val total: String,
    @SerializedName("totalPages")
    val totalPages: String
)