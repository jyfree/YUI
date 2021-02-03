package com.jy.yui.selector.inter

import android.view.View
import com.jy.yui.selector.YSelector

interface ISelectorUtil<T, V : View> {
    /**
     * 目标view
     * @param v 需要设置样式的view
     */
    fun into(view: V): YSelector

    fun build(): T
}