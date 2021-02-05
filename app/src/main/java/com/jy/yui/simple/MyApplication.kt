package com.jy.yui.simple

import android.app.Application
import com.jy.yui.YUI
import com.jy.yui.simple.glide.GlideImageLoadStrategy

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        YUI.init(this, GlideImageLoadStrategy(),true)
    }
}