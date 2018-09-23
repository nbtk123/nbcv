package com.nbtk.nbcv.base.application

import android.app.Application
import android.content.Context

class CvApp: Application() {

    companion object {
        lateinit var appContext: Context private set
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}