package com.jy.yui.simple

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.simple.activity.BannerSimpleActivity
import com.jy.yui.simple.activity.SelectorSimpleActivity
import com.jy.yui.simple.activity.ShapeTextViewSimpleActivity
import com.jy.yui.simple.activity.TouchImageViewSimpleActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.btnSelectorSimple -> SelectorSimpleActivity.startAct(this)
            R.id.btnShapeTVSimple -> ShapeTextViewSimpleActivity.startAct(this)
            R.id.btnTouchIVSimple -> TouchImageViewSimpleActivity.startAct(this)
            R.id.btnBannerSimple -> BannerSimpleActivity.startAct(this)
        }
    }
}
