package com.jy.yui.simple.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.simple.R


/**

 * @Author Administrator
 * @Date 2019/10/21-13:50
 * @TODO ShapeTextView示例
 */
class ShapeTextViewSimpleActivity : AppCompatActivity() {

    companion object {
        fun startAct(context: Context) {
            val intent = Intent()
            intent.setClass(context, ShapeTextViewSimpleActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_tv)
    }

}