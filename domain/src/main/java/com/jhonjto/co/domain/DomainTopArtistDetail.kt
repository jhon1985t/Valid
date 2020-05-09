package com.jhonjto.co.domain

/**
 * Created by jhon on 7/05/2020
 */
data class DomainTopArtistDetail(
    val artist: DomainArtistDetail
)

data class DomainArtistDetail(
    val bio: DomainBio,
    val image: ArrayList<DomainImage>,
    val mbid: String,
    val name: String,
    val ontour: String,
    val similar: DomainSimilar,
    val stats: DomainStats,
    val streamable: String,
    val tags: DomainTags,
    val url: String
)

data class DomainBio(
    val content: String,
    val links: DomainLinks,
    val published: String,
    val summary: String
)

data class DomainSimilar(
    val artist: ArrayList<DomainArtistX>
)

data class DomainStats(
    val listeners: String,
    val playcount: String
)

data class DomainTags(
    val tag: ArrayList<DomainTag>
)

data class DomainLinks(
    val link: DomainLink
)

data class DomainLink(
    val text: String,
    val href: String,
    val rel: String
)

data class DomainArtistX(
    val image: ArrayList<DomainImageX>,
    val name: String,
    val url: String
)

data class DomainImageX(
    val text: String,
    val size: String
)

data class DomainTag(
    val name: String,
    val url: String
)