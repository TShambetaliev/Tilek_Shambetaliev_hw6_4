package com.example.tilek_shambetaliev_hw6_4

import android.app.Application
import com.example.tilek_shambetaliev_hw6_4.repository.Repository

class App : Application() {

//    override fun onCreate() {
//        super.onCreate()
//        startKoin{
//            androidContext(this@App)
//            modules(koinModelus)
//        }
//    }

    companion object {
        val repository = Repository()
    }
}