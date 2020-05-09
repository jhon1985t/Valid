package com.jhonjto.co.valid.utils

import android.content.Context

/**
 * Created by jhon on 8/05/2020
 */
object AndroidHelper {

    private var context: Context? = null

    fun init(context: Context) {
        this.context = context
    }

    fun getString(id: Int): String {
        return context?.getString(id) ?: Constants.DEFAULT_STRING
    }
}