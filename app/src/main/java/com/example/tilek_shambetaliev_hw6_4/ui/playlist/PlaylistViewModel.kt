package com.example.tilek_shambetaliev_hw6_4.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tilek_shambetaliev_hw6_4.BuildConfig
import com.example.tilek_shambetaliev_hw6_4.core.base.BaseViewModel
import com.example.tilek_shambetaliev_hw6_4.data.remote.model.PlayLists
import com.example.tilek_shambetaliev_hw6_4.data.remote.ApiService
import com.example.tilek_shambetaliev_hw6_4.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlaylistViewModel : BaseViewModel() {

    private val apiService: ApiService = RetrofitClient.create()

    fun getPlaylist(): LiveData<PlayLists> {
        return playlists()
    }

    private fun playlists(): LiveData<PlayLists> {
        val data = MutableLiveData<PlayLists>()

        apiService.getPlaylists(
            BuildConfig.API_KEY, "snippet,contentDetails", "UCWOA1ZGywLbqmigxE4Qlvuw"
        ).enqueue(object : Callback<PlayLists> {
            override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                println(t.stackTrace)
            }
        })
        return data
    }
}