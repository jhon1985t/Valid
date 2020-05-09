package com.jhonjto.co.valid.mappers

import com.jhonjto.co.domain.*
import com.jhonjto.co.valid.data.server.TopArtistDetail
import com.jhonjto.co.valid.data.server.ResponseArtists

/**
 * Created by jhon on 8/05/2020
 */
fun ResponseArtists.toDomainArtists(): DomainResponseArtist {
    val resultImageArtistsTop = ArrayList<DomainImage>()
    val resultDomainArtistsTop = ArrayList<DomainArtist>()

    this.artist.artist.forEach {
        it.image.forEach { result ->
            resultImageArtistsTop.add(DomainImage(result.text, result.size))
        }
    }

    this.artist.artist.forEach { result ->
        resultDomainArtistsTop.add(
            DomainArtist(resultImageArtistsTop, result.listeners,
            result.mbid, result.name, result.streamable, result.url)
        )
    }

    return DomainResponseArtist(
        topArtists = DomainTopArtists(
            artist = resultDomainArtistsTop,
            attr = DomainAttr(country = "", page = "", perPage = "", total = "", totalPages = "")
        )
    )
}

fun TopArtistDetail.toDomainArtistsDetail(): DomainTopArtistDetail {
    val resultDomainTag = ArrayList<DomainTag>()
    val resultDomainImageX = ArrayList<DomainImageX>()
    val resultDomainArtistX = ArrayList<DomainArtistX>()
    val resultDomainImage = ArrayList<DomainImage>()

    this.artist.tags.tag.forEach { result ->
        resultDomainTag.add(DomainTag(result.name, result.url))
    }

    this.artist.similar.artist.forEach {
        it.image.forEach { result ->
            resultDomainImageX.add(DomainImageX(result.text, result.size))
        }
    }

    this.artist.similar.artist.forEach { result ->
        resultDomainArtistX.add(DomainArtistX(resultDomainImageX, result.name, result.url))
    }

    this.artist.image.forEach { result ->
        resultDomainImage.add(DomainImage(result.text, result.size))
    }

    return DomainTopArtistDetail(
        artist = DomainArtistDetail(
            bio = DomainBio(
                content = "",
                links = DomainLinks(
                    link = DomainLink(
                        text = "",
                        href = "",
                        rel = ""
                    )
                ),
                published = "",
                summary = ""
            ),
            image = resultDomainImage,
            mbid = "",
            name = "",
            ontour = "",
            similar = DomainSimilar(
                artist = resultDomainArtistX
            ),
            stats = DomainStats(
                listeners = "",
                playcount = ""
            ),
            streamable = "",
            tags = DomainTags(
                tag = resultDomainTag
            ),
            url = ""
        )
    )
}