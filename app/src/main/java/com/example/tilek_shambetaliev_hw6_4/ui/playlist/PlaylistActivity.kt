package com.example.tilek_shambetaliev_hw6_4.ui.playlist


import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.tilek_shambetaliev_hw6_4.BuildConfig
import com.example.tilek_shambetaliev_hw6_4.core.base.BaseActivity
import com.example.tilek_shambetaliev_hw6_4.data.remote.model.PlayLists
import com.example.tilek_shambetaliev_hw6_4.databinding.ActivityPlaylistBinding
import com.example.tilek_shambetaliev_hw6_4.ui.detail.DetailActivity
import com.example.tilek_shambetaliev_hw6_4.ui.playlist.adapter.PlaylistAdapter

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {

    private var adapter = PlaylistAdapter(this::onClick)

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun setupLiveData() {
        super.setupLiveData()

        viewModel.getPlaylist().observe(this) {
            binding.recyclerView.adapter = adapter

            adapter.addList(it.items)
        }
    }

    private fun onClick(item: PlayLists.Item) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(ID, item.snippet.title)
        startActivity(intent)
    }

    companion object {
        const val ID = "ID"
    }

}