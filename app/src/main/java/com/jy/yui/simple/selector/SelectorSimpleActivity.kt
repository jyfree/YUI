package com.jy.yui.simple.selector

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.selector.selector.CompoundDrawableSelector
import com.jy.yui.simple.R
import kotlinx.android.synthetic.main.simple_selector_activity.*


/**

 * @Author Administrator
 * @Date 2019/10/21-13:50
 * @TODO Selector示例
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
        setContentView(R.layout.simple_selector_activity)
        initUI(savedInstanceState)
    }


    private fun initUI(savedInstanceState: Bundle?) {
        tv_Shadow.setShadow(
            R.color.colorAccent,
            R.color.back
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
        iv_touch.setOnClickListener {
            Log.d("YLog", "点我了")
        }
    }
}