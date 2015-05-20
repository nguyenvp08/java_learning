package com.example.javalearning.view;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.javalearning.R;

public class NoteView extends TextView {

	public NoteView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}
	
	public NoteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}
	
	public NoteView(Context context) {
		super(context);
		initView();
	}
	
	private void initView() {
		int paddingSize = getResources().getDimensionPixelSize(R.dimen.note_view_padding) / 2;
		LinearLayout.LayoutParams param = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		param.setMargins(16, 0, 16, 16);
		setLayoutParams(param);
		setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
		setTextAppearance(getContext(), android.R.style.TextAppearance_Medium);
		setBackgroundResource(R.drawable.blue_rounded_rectangle);
	}
	
	public void setCustomText(String text) {
		setText(Html.fromHtml(text));
	}
}
