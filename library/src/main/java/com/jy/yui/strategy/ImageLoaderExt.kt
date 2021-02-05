package com.jy.yui.strategy

import android.widget.ImageView

/**
 * @description imageLoader扩展类，便于java调用
 * @date: 2021/2/5 14:25
 * @author: jy
 */
object ImageLoaderExt {
    fun loadImage(imageView: ImageView, path: Any?, placeholderRes: Int) {
        ImageLoader.get().loadImage(imageView, path, placeholderRes)
    }
}