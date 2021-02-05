package com.jy.yui.widget.banner;

import android.content.Context;
import android.util.AttributeSet;

import com.jy.yui.R;
import com.jy.yui.widget.banner.base.BaseImageBanner;

/**
 * @description 简单的图片轮播
 * @date: 2021/2/5 14:38
 * @author: jy
 */
public class SimpleImageBanner extends BaseImageBanner<SimpleImageBanner> {

    public SimpleImageBanner(Context context) {
        super(context);
    }

    public SimpleImageBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleImageBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.yui_adapter_simple_image;
    }

    @Override
    protected int getImageViewId() {
        return R.id.iv;
    }

}
