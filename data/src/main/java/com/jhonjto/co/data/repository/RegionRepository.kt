package com.jhonjto.co.data.repository

import com.jhonjto.co.data.source.LocationDataSource
import com.jhonjto.co.data.source.PermissionChecker
import com.jhonjto.co.data.source.PermissionChecker.Permission.COARSE_LOCATION

/**
 * Created by jhon on 8/05/2020
 */
class RegionRepository (
    private val locationDataSource: LocationDataSource,
    private val permissionChecker: PermissionChecker
) {

    companion object {
        const val DEFAULT_REGION = "US"
    }

    suspend fun findLastRegion(): String {

        return if (permissionChecker.check(COARSE_LOCATION)) {
            locationDataSource.findLastRegion() ?: DEFAULT_REGION
        } else {
            DEFAULT_REGION
        }
    }
}