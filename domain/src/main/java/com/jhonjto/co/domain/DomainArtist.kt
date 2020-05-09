package com.jhonjto.co.domain

/**
 * Created by jhon on 9/05/2020
 */
data class DomainArtist(
    val image: ArrayList<DomainImage>,
    val listeners: String,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)