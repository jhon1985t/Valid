package com.jhonjto.co.usecases

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.data.repository.ArtistsListRepository
import com.jhonjto.co.domain.DomainResponseArtist

/**
 * Created by jhon on 7/05/2020
 */
class GetTopArtists(private val repository: ArtistsListRepository) {

    suspend fun invoke(country: String): Resource<DomainResponseArtist>? = repository.getAllArtists(country)
}