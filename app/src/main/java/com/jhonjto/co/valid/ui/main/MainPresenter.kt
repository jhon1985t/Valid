package com.jhonjto.co.valid.ui.main

import android.util.Log
import com.jhonjto.co.data.common.Resource
import com.jhonjto.co.data.common.Status.*
import com.jhonjto.co.data.repository.RegionRepository
import com.jhonjto.co.domain.DomainResponseArtist
import com.jhonjto.co.usecases.GetTopArtists
import com.jhonjto.co.valid.R
import com.jhonjto.co.valid.ui.common.Scope
import com.jhonjto.co.valid.utils.AndroidHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by jhon on 8/05/2020
 */
class MainPresenter(
    private val view: MainContract.View?,
    private val regionRepository: RegionRepository,
    private val getTopArtists: GetTopArtists
): MainContract.Presenter, Scope by Scope.Impl() {

    override fun requestLocationPermission() {
        launch {
            regionRepository.findLastRegion()
        }
    }

    override fun initView() {
        launch {
            loadData(regionRepository.findLastRegion())
        }
    }

    override fun loadData(country: String) {
        launch {
            view?.showProgress()
            val topArtists = async(Dispatchers.IO) {
                getTopArtists.invoke(country)
            }
            showTopArtistsList(topArtists.await())
        }
    }

    private fun showTopArtistsList(topArtists: Resource<DomainResponseArtist>?) {
        when (topArtists?.status) {
            SUCCESS -> {
                topArtists.data?.let {
                    view?.showTopArtists(it.topArtists.artist)
                    view?.hideProgress()
                } ?: kotlin.run {
                    view?.showMessage(AndroidHelper.getString(R.string.error_show_information))
                    view?.hideProgress()
                }
            }
            ERROR -> {
                view?.showMessage(AndroidHelper.getString(R.string.error_load_data))
                view?.hideProgress()
                Log.d("MainPresenter", "${topArtists.message}")
            }
            LOADING -> {
                view?.showProgress()
            }
        }
    }

    override fun onCreateScope() {
        createScope()
    }

    override fun onDestroyScope() {
        destroyScope()
    }
}