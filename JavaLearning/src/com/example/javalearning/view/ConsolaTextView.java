package com.example.javalearning.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class ConsolaTextView extends TextView {
	
	/**
	 * 
	 * @param context : context
	 * @param attrs : atts
	 * @param defStyleAttr : stryle
	 */
	public ConsolaTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setupFont();
	}
	
	/**
	 * 
	 * @param context : context
	 * @param attrs : atts
	 */
	public ConsolaTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setupFont();
	}
	
	/**
	 * 
	 * @param context : context
	 */
	public ConsolaTextView(Context context) {
		super(context);
		setupFont();
	}
	
	/**
	 * setup font.
	 */
	private void setupFont() {
		Typeface font = Typeface.createFromAsset(getContext().getAssets(), "font/consolas.ttf"); 
		if (font != null) {
			setTypeface(font);
			setLineSpacing(1F, 1.5F);
		}
	}
}