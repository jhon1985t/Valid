package com.jhonjto.co.valid.ui.main

import com.jhonjto.co.domain.DomainArtist

/**
 * Created by jhon on 8/05/2020
 */
interface MainContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showMessage(message: String)
        fun showTopArtists(topArtists: ArrayList<DomainArtist>)
        fun navigateToDetailActivity()
    }

    interface Presenter {
        fun requestLocationPermission()
        fun initView()
        fun loadData(country: String)
        fun onDestroyScope()
        fun onCreateScope()
    }
}