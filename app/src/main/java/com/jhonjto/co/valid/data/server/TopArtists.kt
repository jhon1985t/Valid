package com.jhonjto.co.valid.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by jhon on 9/05/2020
 */
data class TopArtists(
    @SerializedName("@attr")
    val attr: Attr,
    @SerializedName("artist")
    val artist: List<Artist>
)