package com.jy.yui.simple.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.selector.YSelector
import com.jy.yui.simple.R
import kotlinx.android.synthetic.main.activity_count_down.*


/**
 * @description 倒计时View示例
 * @date: 2021/2/5 14:44
 * @author: jy
 */
class CountDownSimpleActivity : AppCompatActivity() {

    companion object {
        fun startAct(context: Context) {
            val intent = Intent()
            intent.setClass(context, CountDownSimpleActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        YSelector.colorSelector()
            .defaultColor(R.color.colorAccent)
            .pressedColor("#cccccc")
            .disabledColor("#cccccc")
            .into(cdTV)
        cdTV.setOnClickListener {
            cdTV.startCountDown()
        }
        YSelector.shapeSelector()
            .defaultBgColor(R.color.colorAccent)
            .pressedBgColor("#cccccc")
            .disabledBgColor("#cccccc")
            .selectorColor(
                YSelector.colorSelector()
                    .defaultColor("#ffffff")
                    .pressedColor("#ff0000")
                    .disabledColor("#ff0000").build()
            )
            .radius(20f)
            .into(cdBtn)
        cdBtn.setOnClickListener {
            cdBtn.startCountDown()
        }
    }


}