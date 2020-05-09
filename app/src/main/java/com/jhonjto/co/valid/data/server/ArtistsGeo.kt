package com.jhonjto.co.valid.data.server

import com.google.gson.GsonBuilder
import com.jhonjto.co.valid.BuildConfig
import com.jhonjto.co.valid.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by jhon on 8/05/2020
 */
object ArtistsGeo {

    private fun addInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun buildService(): Retrofit {

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(addInterceptor())
            .connectTimeout(Constants.connectTimeout, TimeUnit.MINUTES)
            .readTimeout(Constants.readTimeout, TimeUnit.SECONDS)
            .writeTimeout(Constants.writeTimeout, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}