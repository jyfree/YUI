package com.jy.yui.simple.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.anim.ZoomInAnimator
import com.jy.yui.simple.DemoDataProvider
import com.jy.yui.simple.MainActivity
import com.jy.yui.simple.R
import com.jy.yui.transform.RotateDownTransformer
import kotlinx.android.synthetic.main.activity_guide.*


/**
 * @description 引导页示例
 * @date: 2021/2/5 14:44
 * @author: jy
 */
class GuideSimpleActivity : AppCompatActivity() {

    companion object {
        fun startAct(context: Context) {
            val intent = Intent()
            intent.setClass(context, GuideSimpleActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        init()
    }

    private fun init() {
        gb.setIndicatorWidth(6f).setIndicatorHeight(6f).setIndicatorGap(12f)
            .setIndicatorCornerRadius(3.5f)
            .setSelectAnimClass(ZoomInAnimator::class.java)
            .setTransformerClass(RotateDownTransformer::class.java)
            .barPadding(0f, 10f, 0f, 10f)
            .setSource(DemoDataProvider.getUserGuides())
            .startScroll()

        gb.setOnJumpClickListener {
            MainActivity.startAct(this)
            finish()
        }
    }

}