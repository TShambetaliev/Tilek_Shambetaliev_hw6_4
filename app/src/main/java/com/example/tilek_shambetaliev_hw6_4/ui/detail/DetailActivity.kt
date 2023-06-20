package com.example.tilek_shambetaliev_hw6_4.ui.detail

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tilek_shambetaliev_hw6_4.core.base.BaseActivity
import com.example.tilek_shambetaliev_hw6_4.databinding.ActivityDetailBinding
import com.example.tilek_shambetaliev_hw6_4.ui.playlist.PlaylistActivity

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun setupLiveData() {
        super.setupLiveData()
        getExtra()
    }

    private fun getExtra() {
        val getIntent = intent.getStringExtra(PlaylistActivity.ID)
        Toast.makeText(this, getIntent, Toast.LENGTH_SHORT).show()
    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }
}