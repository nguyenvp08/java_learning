package com.example.javalearning.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FitWidthImageView extends ImageView {

	public FitWidthImageView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	public FitWidthImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	public FitWidthImageView(Context context) {
		super(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		try {
	        Drawable drawable = getDrawable();

	        if (drawable == null) {
	        	super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	        } else {
	        	int width = drawable.getIntrinsicWidth();
	        	int height = drawable.getIntrinsicHeight();
	        	
	        	int realWidth = MeasureSpec.getSize(widthMeasureSpec);
	        	float ratio = (float) realWidth / width;
	        	int realHeight = (int) (height * ratio);
	        	setMeasuredDimension(realWidth, realHeight);
	        }
	    } catch (Exception e) {
	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	    }
	}
}
