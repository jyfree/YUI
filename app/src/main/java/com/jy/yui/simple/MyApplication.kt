package com.jy.yui.simple

import android.app.Application
import com.jy.yui.YUI

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        YUI.init(this)
    }
}