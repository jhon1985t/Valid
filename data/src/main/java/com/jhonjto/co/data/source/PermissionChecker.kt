package com.jhonjto.co.data.source

/**
 * Created by jhon on 8/05/2020
 */
interface PermissionChecker {

    enum class Permission {
        COARSE_LOCATION
    }

    suspend fun check(permission: Permission): Boolean
}