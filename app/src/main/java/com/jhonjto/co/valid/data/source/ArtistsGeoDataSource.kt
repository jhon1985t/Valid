package com.jhonjto.co.valid.data.source

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.data.source.RemoteDataSource
import com.jhonjto.co.domain.DomainResponseArtist
import com.jhonjto.co.domain.DomainTopArtistDetail
import com.jhonjto.co.valid.data.server.ArtistsGeoService
import com.jhonjto.co.valid.mappers.toDomainArtists
import com.jhonjto.co.valid.mappers.toDomainArtistsDetail
import com.jhonjto.co.valid.utils.ResponseHandler
import retrofit2.Retrofit

/**
 * Created by jhon on 8/05/2020
 */
class ArtistsGeoDataSource(retrofit: Retrofit): RemoteDataSource {

    companion object {
        private const val API_KEY = "829751643419a7128b7ada50de590067"
    }

    private val api = retrofit.run { create(ArtistsGeoService::class.java) }

    override suspend fun listArtists(country: String): Resource<DomainResponseArtist> {
        return try {

            val artists = api.listArtistsAsync(
                country = country
            ).run {
                this.toDomainArtists()
            }

            ResponseHandler().handleSuccess(artists)
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }

    override suspend fun listArtistDetail(artist: String): Resource<List<DomainTopArtistDetail>> {
        return try {

            val artistDetail = api.detailArtistAsync(
                artist = artist
            ).map {
                it.toDomainArtistsDetail()
            }

            ResponseHandler().handleSuccess(artistDetail)
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }
}