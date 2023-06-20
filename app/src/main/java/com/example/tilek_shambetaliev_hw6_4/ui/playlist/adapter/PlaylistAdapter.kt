package com.example.tilek_shambetaliev_hw6_4.ui.playlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tilek_shambetaliev_hw6_4.core.utils.loadImage
import com.example.tilek_shambetaliev_hw6_4.databinding.ItemPlaylistBinding
import com.example.tilek_shambetaliev_hw6_4.data.remote.model.PlayLists

class PlaylistAdapter(private val onCLick: (PlayLists.Item) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private var list = ArrayList<PlayLists.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(liste: List<PlayLists.Item>) {
        this.list = liste as ArrayList<PlayLists.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistAdapter.PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: PlayLists.Item) {
            with(binding) {
                tvTitle.text = item.snippet.title
                tvCountVideos.text = item.contentDetails?.itemCount.toString() + " videos series"
                imgPreview.loadImage(item.snippet.thumbnails.default.url)

                cvPlaylist.setOnClickListener {
                    onCLick.invoke(item)
                }
            }
        }
    }
}


//(private val onNavigateVideos: (item: PlayLists.Item) -> Unit) :
//RecyclerView.Adapter<PlaylistAdapter.PlaylistsViewHolder>() {
//    private var listOfItems = arrayListOf<PlayLists>()
//
//    fun setList(list: List<PlayLists.Item>) {
//        this.listOfItems = list as ArrayList<PlayLists.Item>
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
//        return PlaylistsViewHolder(
//            ItemPlaylistBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return listOfItems.size
//    }
//
//    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
//        holder.bind(listOfItems[position])
//    }
//
//    inner class PlaylistsViewHolder(private val binding: ItemPlaylistBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: PlayLists.Item) {
//            with(binding) {
//                imgPreview.loadImage(item.snippet.thumbnails.default.url)
//                tvTitle.text = item.snippet.title
//                tvCountVideos.text = String.format(
//                    itemView.context.getString(R.string.videos_series),
//                    item.contentDetails.itemCount
//                )
//                itemView.setOnClickListener {
//                    onNavigateVideos(item)
//                }
//            }
//        }
//    }
