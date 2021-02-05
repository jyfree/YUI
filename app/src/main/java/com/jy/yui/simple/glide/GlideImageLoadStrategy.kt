package com.jy.yui.simple.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jy.yui.strategy.AlignEnum
import com.jy.yui.strategy.IImageLoadStrategy

/**
 * @description glide加载图片策略
 * @date: 2021/2/5 14:45
 * @author: jy
 */
class GlideImageLoadStrategy : IImageLoadStrategy {
    override fun loadImage(
        imageView: ImageView,
        path: Any?,
        placeholderRes: Int,
        errorRes: Int,
        circle: Int,
        align: AlignEnum,
        strokeWidth: Float,
        strokeColor: Int,
        timeoutMs: Int

    ) {
        var builder = Glide.with(imageView).load(path)
        if (placeholderRes != 0) {
            builder.placeholder(placeholderRes).also { builder = it }
        }
        if (errorRes != 0) {
            builder.error(errorRes).also { builder = it }
        }
        if (circle != 0) {
            if (circle == 360) {
                builder.apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .also { builder = it }
            } else {
                builder.apply(RequestOptions.bitmapTransform(RoundedCorners(circle)))
                    .also { builder = it }
            }
        }
        when (align) {
            AlignEnum.CENTER_CROP -> builder.centerCrop()
            AlignEnum.CENTER_INSIDE -> builder.centerInside()
            AlignEnum.FIT_CENTER -> builder.fitCenter()
            else -> {
            }
        }
        if (strokeWidth > 0) {
            builder.apply(
                RequestOptions.bitmapTransform(
                    GlideCircleWithBorder(
                        strokeWidth,
                        strokeColor
                    )
                )
            ).also { builder = it }
        }
        if (timeoutMs != 0) {
            builder.timeout(timeoutMs).also { builder = it }
        }
        builder.into(imageView)
    }
}