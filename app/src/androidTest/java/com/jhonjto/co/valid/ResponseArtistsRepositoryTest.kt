package com.jhonjto.co.valid

import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.data.repository.ArtistDetailRepositoryImpl
import com.jhonjto.co.data.repository.ArtistsListRepositoryImpl
import com.jhonjto.co.data.source.RemoteDataSource
import com.jhonjto.co.domain.DomainResponseArtist
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import mockedArtistsList
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by jhon on 7/05/2020
 */

@RunWith(MockitoJUnitRunner::class)
class ResponseArtistsRepositoryTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource
    @Mock
    lateinit var artistsListRepository: ArtistsListRepositoryImpl
    @Mock
    lateinit var artistDetailRepository: ArtistDetailRepositoryImpl

    @Before
    fun setup() {
        artistsListRepository =
            ArtistsListRepositoryImpl(remoteDataSource)
        artistDetailRepository =
            ArtistDetailRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getMovies() {
        runBlocking {

            val remoteArtistsList: Resource<DomainResponseArtist> = Resource.success(mockedArtistsList)
            whenever(remoteDataSource.listArtists("").data?.topArtists?.artist?.isEmpty()).thenReturn(false)
            whenever(remoteDataSource.listArtists("spain")).thenReturn(remoteArtistsList)

            //artistsListRepository.getAllArtists()

            //verify(remoteDataSource).listArtists().data
        }
    }
}