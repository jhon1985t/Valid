package com.jhonjto.co.valid.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by jhon on 7/05/2020
 */
data class ResponseArtists(
    @SerializedName("topartists")
    val artist: TopArtists
)