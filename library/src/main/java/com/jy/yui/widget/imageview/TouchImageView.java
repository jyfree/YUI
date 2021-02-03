package com.jy.yui.widget.imageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatImageView;

import com.jy.yui.R;

/**
 * @description 有点击效果的imageView
 * @date: 2021/2/3 16:38
 * @author: jy
 */
public class TouchImageView extends AppCompatImageView {

    private int mSelectedMaskColor;

    public TouchImageView(Context context) {
        this(context, null);
    }

    public TouchImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TouchImageView);
        mSelectedMaskColor = typedArray.getColor(R.styleable.TouchImageView_tiv_selected_mask_color, Color.TRANSPARENT);
        typedArray.recycle();
    }

    /**
     * 设置点击遮罩层颜色
     *
     * @param selectedMaskColor
     */
    public void setSelectedMaskColor(int selectedMaskColor) {
        this.mSelectedMaskColor = selectedMaskColor;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.setColorFilter(mSelectedMaskColor);
                return true;
            case MotionEvent.ACTION_UP:
                this.setColorFilter(null);
                this.performClick();
                break;
            case MotionEvent.ACTION_CANCEL:
                this.setColorFilter(null);
                break;
        }
        return super.onTouchEvent(event);
    }
}
