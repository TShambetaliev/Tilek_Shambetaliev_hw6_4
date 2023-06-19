package com.example.tilek_shambetaliev_hw6_4.ui.playlist


import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import com.example.tilek_shambetaliev_hw6_4.core.base.BaseActivity
import com.example.tilek_shambetaliev_hw6_4.data.remote.model.PlayLists
import com.example.tilek_shambetaliev_hw6_4.databinding.ActivityPlaylistBinding
import com.example.tilek_shambetaliev_hw6_4.ui.playlist.adapter.PlaylistAdapter

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(): ActivityPlaylistBinding {
            return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun setupLiveData() {
        super.setupLiveData()
    }
}