package com.jhonjto.co.valid.ui.adapters

import android.graphics.PointF
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.jhonjto.co.domain.DomainArtist
import com.jhonjto.co.valid.R
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation
import kotlinx.android.synthetic.main.view_top_artists.view.*

/**
 * Created by jhon on 9/05/2020
 */
class TopArtistsAdapter(private val listener: (DomainArtist) -> Unit)
    : RecyclerView.Adapter<TopArtistsAdapter.ViewHolder>() {

    private var domainArtist = ArrayList<DomainArtist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_top_artists, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = domainArtist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artistsTopList = domainArtist[position]
        holder.bind(artistsTopList)
        holder.itemView.artistThumb.setOnClickListener {
            listener.invoke(artistsTopList)
        }
    }

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        fun bind(domainArtist: DomainArtist) = with(itemView) {
            artistListeners.text = domainArtist.listeners
            artistMbid.text = domainArtist.mbid
            artistName.text = domainArtist.name
            Glide.with(context)
                .load(domainArtist.url)
                .placeholder(android.R.drawable.stat_notify_error)
                .error(android.R.drawable.stat_notify_error)
                .fallback(android.R.drawable.stat_notify_error)
                .skipMemoryCache(true)
                .transform(CircleCrop(),
                    BlurTransformation(5), //3
                    ContrastFilterTransformation(1.0f), //4
                    VignetteFilterTransformation(
                        PointF(0.5f, 0.5f),
                        floatArrayOf(0f, 0f, 0f),
                        0f,
                        4f)
                )
                .into(artistThumb)
        }
    }

    fun getArtistsList(domainArtist: ArrayList<DomainArtist>) {
        this.domainArtist.clear()
        this.domainArtist.addAll(domainArtist)
        notifyDataSetChanged()
    }
}