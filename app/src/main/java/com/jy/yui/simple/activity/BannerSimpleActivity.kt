package com.jy.yui.simple.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.anim.ZoomInAnimator
import com.jy.yui.simple.DemoDataProvider
import com.jy.yui.simple.R
import com.jy.yui.widget.banner.BannerItem
import kotlinx.android.synthetic.main.activity_banner.*


/**
 * @description banner示例
 * @date: 2021/2/5 14:45
 * @author: jy
 */
class BannerSimpleActivity : AppCompatActivity() {

    private var mData: List<BannerItem>? = null

    companion object {
        fun startAct(context: Context) {
            val intent = Intent()
            intent.setClass(context, BannerSimpleActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        mData = DemoDataProvider.getBannerList()
        init()
    }

    private fun init() {
        //图片轮播简单使用
        simple_usage.setSource(mData)
            .setIsOnePageLoop(false)
            .startScroll()

        //复杂用法
        most_complex_usage.setSource(mData)
            .setSelectAnimClass(ZoomInAnimator::class.java)
            .startScroll()
    }


}