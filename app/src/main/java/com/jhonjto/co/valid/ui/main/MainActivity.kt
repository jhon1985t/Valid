package com.jhonjto.co.valid.ui.main

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhonjto.co.data.repository.ArtistsListRepositoryImpl
import com.jhonjto.co.data.repository.RegionRepository
import com.jhonjto.co.domain.DomainArtist
import com.jhonjto.co.usecases.GetTopArtists
import com.jhonjto.co.valid.R
import com.jhonjto.co.valid.data.AndroidPermissionChecker
import com.jhonjto.co.valid.data.PlayServicesLocationDataSource
import com.jhonjto.co.valid.data.server.ArtistsGeo
import com.jhonjto.co.valid.data.source.ArtistsGeoDataSource
import com.jhonjto.co.valid.ui.OnClickListeners
import com.jhonjto.co.valid.ui.adapters.TopArtistsAdapter
import com.jhonjto.co.valid.ui.common.PermissionRequester
import com.jhonjto.co.valid.utils.AndroidHelper
import com.jhonjto.co.valid.utils.toastMessage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress_bar.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private var listener: OnClickListeners? = null

    private val coarsePermissionRequester =
        PermissionRequester(this, ACCESS_COARSE_LOCATION)

    private val adapter by lazy {
        TopArtistsAdapter { topArtists ->
            listener?.navigateTo(topArtists.name)
        }
    }

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(
            this, RegionRepository(
                PlayServicesLocationDataSource(application),
                AndroidPermissionChecker(application)
            ), GetTopArtists(
                ArtistsListRepositoryImpl(
                    ArtistsGeoDataSource(
                        ArtistsGeo.buildService()
                    )
                )
            )
        )

        presenter?.onCreateScope()
        coarsePermissionRequester.request { presenter?.requestLocationPermission() }
        presenter?.initView()

        artistsRecyclerView.layoutManager = LinearLayoutManager(this)
        artistsRecyclerView.adapter = adapter
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE

    }

    override fun showMessage(message: String) {
        if (message != AndroidHelper.getString(R.string.error_show_information)) {
            presenter?.initView()
        } else {
            toastMessage(message)
        }
    }

    override fun showTopArtists(topArtists: ArrayList<DomainArtist>) {
        adapter.getArtistsList(topArtists)
    }

    override fun navigateToDetailActivity() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        presenter?.destroyScope()
        super.onDestroy()
    }
}
