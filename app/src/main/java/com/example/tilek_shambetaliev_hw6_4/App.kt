package com.example.tilek_shambetaliev_hw6_4

import android.app.Application
import com.example.tilek_shambetaliev_hw6_4.repository.Repository

class App : Application() {

    companion object {
        val repository = Repository()
    }
}