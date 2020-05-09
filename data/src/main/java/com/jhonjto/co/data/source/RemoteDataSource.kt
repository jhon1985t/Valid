package com.jhonjto.co.data.source

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.domain.DomainResponseArtist
import com.jhonjto.co.domain.DomainTopArtistDetail

/**
 * Created by jhon on 7/05/2020
 */
interface RemoteDataSource {
    suspend fun listArtists(country: String): Resource<DomainResponseArtist>
    suspend fun listArtistDetail(artist: String): Resource<List<DomainTopArtistDetail>>
}