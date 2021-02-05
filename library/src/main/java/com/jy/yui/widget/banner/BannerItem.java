package com.jy.yui.widget.banner;

/**
 * @description 图片轮播条目
 * @date: 2021/2/5 14:08
 * @author: jy
 */
public class BannerItem {
    public String imgUrl;
    public String title;

    public String getImgUrl() {
        return imgUrl;
    }

    public BannerItem setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BannerItem setTitle(String title) {
        this.title = title;
        return this;
    }
}
