package com.jy.yui

import android.app.Application
import android.content.Context

object YUI {
    private var sContext: Application? = null
    /**
     * 必须在全局Application先调用，获取context上下文
     * @param app Application
     */
    fun init(app: Application) {
        sContext = app
    }

    /**
     * 获取上下文
     */
    fun getContext(): Context {
        initialize()
        return sContext!!
    }

    /**
     * 检测是否调用初始化方法
     */
    private fun initialize() {
        if (sContext == null) {
            throw ExceptionInInitializerError("请先在全局Application中调用YUI.init()初始化！")
        }
    }

}