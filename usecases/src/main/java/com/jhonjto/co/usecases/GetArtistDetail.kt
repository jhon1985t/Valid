package com.jhonjto.co.usecases

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.data.repository.ArtistDetailRepository
import com.jhonjto.co.domain.DomainTopArtistDetail

/**
 * Created by jhon on 7/05/2020
 */
class GetArtistDetail(private val repository: ArtistDetailRepository) {

    suspend fun invoke(artist: String): Resource<List<DomainTopArtistDetail>> = repository.getArtistDetail(artist)
}