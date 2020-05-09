package com.jhonjto.co.valid.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by jhon on 8/05/2020
 */
data class TopArtistDetail(
    @SerializedName("artist")
    val artist: ArtistDetail
)

data class ArtistDetail(
    @SerializedName("bio")
    val bio: Bio,
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("ontour")
    val ontour: String,
    @SerializedName("similar")
    val similar: Similar,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("url")
    val url: String
)

data class Bio(
    @SerializedName("content")
    val content: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("published")
    val published: String,
    @SerializedName("summary")
    val summary: String
)

data class Similar(
    @SerializedName("artist")
    val artist: List<ArtistX>
)

data class Stats(
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("playcount")
    val playcount: String
)

data class Tags(
    @SerializedName("tag")
    val tag: List<Tag>
)

data class Links(
    @SerializedName("link")
    val link: Link
)

data class Link(
    @SerializedName("text")
    val text: String,
    @SerializedName("href")
    val href: String,
    @SerializedName("rel")
    val rel: String
)

data class ArtistX(
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class Tag(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)