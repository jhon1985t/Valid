package com.jhonjto.co.valid.data.server

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jhon on 8/05/2020
 */
interface ArtistsGeoService {
    @GET("/2.0/?method=geo.gettopartists&api_key=829751643419a7128b7ada50de590067&format=json")
    suspend fun listArtistsAsync(
        @Query("country") country: String
    ): ResponseArtists

    @GET("/2.0/?method=artist.getinfo&api_key=829751643419a7128b7ada50de590067&format=json")
    suspend fun detailArtistAsync(
        @Query("artist") artist: String
    ): List<TopArtistDetail>
}