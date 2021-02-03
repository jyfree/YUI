package com.jy.yui.simple.selector

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.jy.yui.selector.YSelector
import com.jy.yui.selector.selector.CompoundDrawableSelector

/**
 * @description Selector选择器工具类
 * @date: 2021/2/3 13:42
 * @author: jy
 */
fun View.setShadow(@ColorRes bgColor: Int, @ColorRes shadowColor: Int) {
    YSelector.shadowHelper()
        .setBgColor(bgColor)
        .setShapeRadius(5f)
        .setShadowRadius(5f)
        .setShadowColor(shadowColor)
        .into(this)
}

fun View.setBgColor(@ColorRes bgColor: Int, @ColorRes pressedColor: Int) {
    YSelector.shapeSelector()
        .defaultBgColor(bgColor)
        .pressedBgColor(pressedColor)
        .selectorColor("#000000", "#ffffff")
        .radius(20f)
        .into(this)
}


fun TextView.setTextColor(@ColorRes defColor: Int, @ColorRes pressedColor: Int) {
    YSelector.colorSelector()
        .defaultColor(defColor)
        .pressedColor(pressedColor)
        .into(this)
}

fun View.setBgDrawable(@DrawableRes defDrawableRes: Int, @DrawableRes pressedDrawableRes: Int) {
    YSelector.drawableSelector()
        .defaultDrawable(defDrawableRes)
        .pressedDrawable(pressedDrawableRes)
        .selectorColor("#000000", "#ffffff")
        .into(this)
}

fun TextView.setCompoundDrawable(@DrawableRes defDrawableRes: Int, @DrawableRes pressedDrawableRes: Int, @CompoundDrawableSelector.DrawableOrientation drawableOrientation: String) {
    YSelector.compoundDrawableSelector()
        .setDrawablePadding(5f)
        .setDrawableOrientation(drawableOrientation)
        .defaultDrawable(defDrawableRes)
        .pressedDrawable(pressedDrawableRes)
        .selectorColor("#ff0000", "#000000")
        .into(this)
}