package com.jy.yui.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.simple.activity.SelectorSimpleActivity
import com.jy.yui.simple.activity.ShapeTextViewSimpleActivity
import com.jy.yui.simple.activity.TouchImageViewSimpleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelectorSimple.setOnClickListener {
            SelectorSimpleActivity.startAct(this)
        }
        btnShapeTVSimple.setOnClickListener {
            ShapeTextViewSimpleActivity.startAct(this)
        }
        btnTouchIVSimple.setOnClickListener { TouchImageViewSimpleActivity.startAct(this) }
    }
}
