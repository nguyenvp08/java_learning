package com.example.javalearning.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.javalearning.R;

public class TextContentView extends LinearLayout {

	private TextView mTextView;
	
	public TextContentView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public TextContentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public TextContentView(Context context) {
		super(context);
		initView(context);
	}

	private void initView(Context context) {
		Resources res = context.getResources();
		int margin = res.getDimensionPixelSize(R.dimen.text1_margin);
		
	 	LinearLayout.LayoutParams param =  new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
	 	param.setMargins(margin, margin, margin, margin);
		setLayoutParams(param);
		setOrientation(LinearLayout.HORIZONTAL);

		// add slide view
		View view = new View(context);
		
		LayoutParams slideParam = new LayoutParams(res
				.getDimensionPixelSize(R.dimen.text1_slide_width),
				LayoutParams.MATCH_PARENT);
		slideParam.rightMargin = res.getDimensionPixelSize(R.dimen.text1_margin);
		
		view.setLayoutParams(slideParam);
		view.setBackgroundColor(res.getColor(R.color.color_blue));
		
		addView(view);
		
		mTextView = new TextView(context);
		LayoutParams textParam = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		textParam.topMargin = margin / 2;
		textParam.bottomMargin = margin / 2;
		mTextView.setLayoutParams(textParam);
		mTextView.setTextAppearance(context, android.R.style.TextAppearance_Medium);
		addView(mTextView);
	}
	
	public void setText(String text) {
		mTextView.setText(Html.fromHtml(text));
	}
}
