package com.jhonjto.co.valid

import android.app.Application
import com.jhonjto.co.valid.utils.AndroidHelper

/**
 * Created by jhon on 8/05/2020
 */

class ArtistsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidHelper.init(applicationContext)
    }
}