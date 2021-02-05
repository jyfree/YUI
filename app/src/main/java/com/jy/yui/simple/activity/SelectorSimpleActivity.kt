package com.jy.yui.simple.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.selector.selector.CompoundDrawableSelector
import com.jy.yui.simple.R
import com.jy.yui.simple.utils.*
import kotlinx.android.synthetic.main.activity_selector.*


/**
 * @description Selector示例
 * @date: 2021/2/5 14:44
 * @author: jy
 */
class SelectorSimpleActivity : AppCompatActivity() {

    companion object {
        fun startAct(context: Context) {
            val intent = Intent()
            intent.setClass(context, SelectorSimpleActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)
        initUI(savedInstanceState)

    }


    private fun initUI(savedInstanceState: Bundle?) {
        tv_Shadow.setShadow(
            R.color.colorAccent,
            R.color.colorPrimary
        )
        tv_BgColor.setBgColor(
            R.color.colorAccent,
            R.color.colorPrimary
        )
        tv_TextColor.setTextColor(
            R.color.colorAccent,
            R.color.colorPrimary
        )
        iv_BgDrawable.setBgDrawable(
            R.drawable.icon_up,
            R.drawable.icon_down
        )
        tv_CDrawable.setCompoundDrawable(
            R.drawable.icon_up,
            R.drawable.icon_down,
            CompoundDrawableSelector.TOP
        )
    }
}