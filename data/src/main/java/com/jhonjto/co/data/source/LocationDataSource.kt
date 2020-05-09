package com.jhonjto.co.data.source

/**
 * Created by jhon on 8/05/2020
 */
interface LocationDataSource {

    suspend fun findLastRegion(): String?
}