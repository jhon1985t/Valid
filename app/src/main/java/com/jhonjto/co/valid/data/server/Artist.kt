package com.jhonjto.co.valid.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by jhon on 9/05/2020
 */
data class Artist(
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("url")
    val url: String
)