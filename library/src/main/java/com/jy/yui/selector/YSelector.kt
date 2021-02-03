package com.jy.yui.selector

import com.jy.yui.selector.selector.ColorSelector
import com.jy.yui.selector.selector.CompoundDrawableSelector
import com.jy.yui.selector.selector.DrawableSelector
import com.jy.yui.selector.selector.ShapeSelector


object YSelector {


    /**
     * 设置样式（主要是椭圆和矩形）
     */
    fun shapeSelector(): ShapeSelector = ShapeSelector.getInstance()

    /**
     * 阴影工具类
     */
    fun shadowHelper(): ShadowHelper = ShadowHelper.getInstance()

    /**
     * Color字体颜色选择器
     */
    fun colorSelector(): ColorSelector = ColorSelector.getInstance()


    /**
     * Drawable背景选择器
     */
    fun drawableSelector(): DrawableSelector = DrawableSelector.getInstance()

    /**
     * Drawable方位选择器
     */
    fun compoundDrawableSelector(): CompoundDrawableSelector =
        CompoundDrawableSelector.getInstance()
}