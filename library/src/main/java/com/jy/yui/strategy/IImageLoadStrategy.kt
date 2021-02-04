package com.jy.yui.strategy

import android.graphics.Color
import android.widget.ImageView

/**
 * @description 图片加载策略
 * @date: 2021/2/4 15:19
 * @author: jy
 */
interface IImageLoadStrategy {
    /**
     * 加载图片
     *
     * @param imageView      图片控件
     * @param path           图片资源的索引
     * @param placeholderRes 占位图，默认为0，代表不设置占位图
     * @param errorRes       加载错误图，默认为0，代表不设置加载错误图
     * @param circle         圆角大小，默认为0，代表不设置圆角
     * @param align          对齐方式
     * @param strokeWidth    边线大小，默认为0
     * @param strokeColor    边线颜色，默认白色
     * @param timeoutMs      超时时间，默认为0，代表使用默认加载方式
     */
    fun loadImage(
        imageView: ImageView,
        path: Any?,
        placeholderRes: Int = 0,
        errorRes: Int = 0,
        circle: Int = 0,
        align: AlignEnum = AlignEnum.DEFAULT,
        strokeWidth: Float = 0f,
        strokeColor: Int = Color.WHITE,
        timeoutMs: Int = 0
    )
}