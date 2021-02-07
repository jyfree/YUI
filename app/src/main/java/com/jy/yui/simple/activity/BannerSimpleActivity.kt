package com.jy.yui.simple.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jy.yui.anim.NoAnimator
import com.jy.yui.anim.RotateAnimator
import com.jy.yui.anim.ZoomInAnimator
import com.jy.yui.simple.DemoDataProvider
import com.jy.yui.simple.R
import com.jy.yui.transform.RotateDownTransformer
import com.jy.yui.transform.ZoomOutSlideTransformer
import com.jy.yui.utils.YUILogUtils
import com.jy.yui.widget.banner.BannerItem
import com.jy.yui.widget.banner.base.BaseBanner
import kotlinx.android.synthetic.main.activity_banner.*


/**
 * @description banner示例
 * @date: 2021/2/5 14:45
 * @author: jy
 */
class BannerSimpleActivity : AppCompatActivity(), BaseBanner.OnItemClickListener<BannerItem> {

    private var mData: List<BannerItem>? = null

    companion object {
        fun startAct(context: Context) {
            val intent = Intent()
            intent.setClass(context, BannerSimpleActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        mData = DemoDataProvider.getBannerList()
        init()
    }

    private fun init() {
        //图片轮播简单使用
        simple_usage.setSource(mData)
            .setIsOnePageLoop(false)
            .startScroll()

        //图片轮播复杂使用
        most_complex_usage.setSource(mData)
            .setSelectAnimClass(ZoomInAnimator::class.java)
            .setTransformerClass(ZoomOutSlideTransformer::class.java)
            .setOnItemClickListener(this)
            .startScroll()

        //索引点使用资源图片
        ib_res.setSource(mData)
            .setSelectAnimClass(ZoomInAnimator::class.java)
            .setTransformerClass(RotateDownTransformer::class.java)
            .setOnItemClickListener(this)
            .startScroll()

        //矩形索引点
        ib_rectangle.setSource(mData)
            .setOnItemClickListener(this)
            .startScroll()

        //扁长条索引点
        ib_corner_rectangle.setSource(mData)
            .setOnItemClickListener(this)
            .startScroll()

        //索引在右文字在左
        ib_indicator_right_with_text.setSource(mData)
            .setSelectAnimClass(RotateAnimator::class.java)
            .setUnSelectAnimClass(NoAnimator::class.java)
            .setOnItemClickListener(this)
            .startScroll()

        //索引在左文字在右
        ib_indicator_left_with_text.setSource(mData)
            .setOnItemClickListener(this)
            .startScroll()

        //图片裁剪圆角
        ib_imageCircle_cCrop.setSource(mData)
            .setOnItemClickListener(this)
            .startScroll()

        //图片圆角
        ib_imageCircle.setSource(mData)
            .setOnItemClickListener(this)
            .startScroll()

        //简单的文字轮播
        tb_test.setSource(DemoDataProvider.titles.toList())
            .setOnItemClickListener { view, item, position ->
                YUILogUtils.i(
                    "简单的文字轮播--点击",
                    position
                )
            }
            .startScroll()

    }

    override fun onItemClick(view: View?, item: BannerItem?, position: Int) {
        YUILogUtils.i(
            "图片轮播--点击",
            position
        )
    }


}