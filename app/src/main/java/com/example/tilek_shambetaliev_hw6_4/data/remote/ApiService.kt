package com.example.tilek_shambetaliev_hw6_4.data.remote

import com.example.tilek_shambetaliev_hw6_4.data.remote.model.PlayLists
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
    ): Call<PlayLists>

}
