package com.jhonjto.co.data.repository

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.domain.DomainResponseArtist

/**
 * Created by jhon on 7/05/2020
 */
interface ArtistsListRepository {

    suspend fun getAllArtists(country: String): Resource<DomainResponseArtist>?
}