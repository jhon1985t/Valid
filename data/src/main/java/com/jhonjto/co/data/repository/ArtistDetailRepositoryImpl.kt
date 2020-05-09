package com.jhonjto.co.data.repository

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.data.source.RemoteDataSource
import com.jhonjto.co.domain.DomainTopArtistDetail

/**
 * Created by jhon on 7/05/2020
 */
class ArtistDetailRepositoryImpl(private val remoteDataSource: RemoteDataSource): ArtistDetailRepository {

    override suspend fun getArtistDetail(artist: String): Resource<List<DomainTopArtistDetail>> {
        return remoteDataSource.listArtistDetail(artist)
    }
}