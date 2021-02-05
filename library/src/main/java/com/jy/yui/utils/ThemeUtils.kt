package com.jy.yui.utils

import android.content.Context
import androidx.annotation.AttrRes

/**
 * @description 主题工具类
 * @date: 2021/2/5 19:16
 * @author: jy
 */
object ThemeUtils {

    fun resolveBoolean(
        context: Context, @AttrRes attr: Int,
        fallback: Boolean
    ): Boolean {
        val a = context.obtainStyledAttributes(intArrayOf(attr))
        return try {
            a.getBoolean(0, fallback)
        } finally {
            a.recycle()
        }
    }

    fun resolveFloat(
        context: Context,
        @AttrRes attrRes: Int,
        defaultValue: Float
    ): Float {
        val a = context.obtainStyledAttributes(intArrayOf(attrRes))
        return try {
            a.getFloat(0, defaultValue)
        } finally {
            a.recycle()
        }
    }
}