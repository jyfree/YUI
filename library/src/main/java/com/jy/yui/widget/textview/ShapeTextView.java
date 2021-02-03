package com.jy.yui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import com.jy.yui.R;
import com.jy.yui.YUIHelper;


/**
 * @description 用于需要圆角矩形框背景的TextView的情况, 减少直接使用TextView时引入的shape资源文件
 * @date: 2021/2/3 17:15
 * @author: jy
 */
public class ShapeTextView extends AppCompatTextView {
    private GradientDrawable gd_background = new GradientDrawable();
    private int backgroundColor;
    private int cornerRadius;
    private int strokeWidth;
    private int strokeColor;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;

    public ShapeTextView(Context context) {
        this(context, null);
    }

    public ShapeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainAttributes(context, attrs);
    }

    private void obtainAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ShapeTextView);
        backgroundColor = ta.getColor(R.styleable.ShapeTextView_stv_backgroundColor, Color.TRANSPARENT);
        cornerRadius = ta.getDimensionPixelSize(R.styleable.ShapeTextView_stv_cornerRadius, 0);
        strokeWidth = ta.getDimensionPixelSize(R.styleable.ShapeTextView_stv_strokeWidth, 0);
        strokeColor = ta.getColor(R.styleable.ShapeTextView_stv_strokeColor, Color.TRANSPARENT);
        isRadiusHalfHeight = ta.getBoolean(R.styleable.ShapeTextView_stv_isRadiusHalfHeight, false);
        isWidthHeightEqual = ta.getBoolean(R.styleable.ShapeTextView_stv_isWidthHeightEqual, false);

        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isWidthHeightEqual() && getWidth() > 0 && getHeight() > 0) {
            int max = Math.max(getWidth(), getHeight());
            int measureSpec = View.MeasureSpec.makeMeasureSpec(max, View.MeasureSpec.EXACTLY);
            super.onMeasure(measureSpec, measureSpec);
            return;
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (isRadiusHalfHeight()) {
            setCornerRadius(getHeight() / 2);
        } else {
            setBgSelector();
        }
    }


    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        setBgSelector();
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = YUIHelper.INSTANCE.dip2px(cornerRadius);
        setBgSelector();
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = YUIHelper.INSTANCE.dip2px(strokeWidth);
        setBgSelector();
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        setBgSelector();
    }

    public void setIsRadiusHalfHeight(boolean isRadiusHalfHeight) {
        this.isRadiusHalfHeight = isRadiusHalfHeight;
        setBgSelector();
    }

    public void setIsWidthHeightEqual(boolean isWidthHeightEqual) {
        this.isWidthHeightEqual = isWidthHeightEqual;
        setBgSelector();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public boolean isRadiusHalfHeight() {
        return isRadiusHalfHeight;
    }

    public boolean isWidthHeightEqual() {
        return isWidthHeightEqual;
    }

    private void setDrawable(GradientDrawable gd, int color, int strokeColor) {
        gd.setColor(color);
        gd.setCornerRadius(cornerRadius);
        gd.setStroke(strokeWidth, strokeColor);
    }

    public void setBgSelector() {
        StateListDrawable bg = new StateListDrawable();

        setDrawable(gd_background, backgroundColor, strokeColor);
        bg.addState(new int[]{-android.R.attr.state_pressed}, gd_background);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {//16
            setBackground(bg);
        } else {
            setBackgroundDrawable(bg);
        }
    }
}
