package com.jy.yui.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.simple.activity.GuideSimpleActivity
import com.jy.yui.simple.utils.YHandlerUtils


/**
 * @description 启动页
 * @date: 2021/2/5 14:44
 * @author: jy
 */
class LaunchSimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        //按下home键，程序在后台运行，在桌面点击程序的启动时，会再次打开启动页的解决办法
        if (!isTaskRoot) {
            finish()
            return
        }
        YHandlerUtils.runOnBackThread(Runnable {
            YHandlerUtils.runOnUiThread(Runnable {
                GuideSimpleActivity.startAct(this)
                finish()
            })
        }, 2)
    }

}