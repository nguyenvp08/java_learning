package com.example.javalearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.javalearning.model.Section;
import com.example.javalearning.model.Sections;
import com.example.javalearning.view.TextContentView;
import com.example.javalearning.view.touch.ImageViewTouch;
import com.example.javalearning.view.touch.ImageViewTouchBase.DisplayType;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	private LinearLayout mRootLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	private void initView() {
		mRootLayout = (LinearLayout) findViewById(R.id.layout_root);

		String sectionContent = null;
		try {
			sectionContent = getContentOfFile(getAssets().open("sections.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sections sections = new GsonBuilder().create().fromJson(sectionContent,
				Sections.class);

		for (Section section : sections.sectionList) {
			if (section.mediaType == 1) {
				TextContentView contentView = new TextContentView(this);
				mRootLayout.addView(contentView);
				contentView.setText(section.text);
			}

			if (section.mediaType == 3) {
				ImageView touch = new ImageView(this);
				try {
					LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
							LayoutParams.MATCH_PARENT,
							LayoutParams.WRAP_CONTENT);
					param.setMargins(16, 0, 16, 16);
					touch.setLayoutParams(param);
					touch.setTag(section.imagePath);
					
					if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
						touch.setImageDrawable(new BitmapDrawable(
								getResources(), BitmapFactory
										.decodeStream(getAssets().open(
												section.imagePath))));
					} else {
						touch.setImageDrawable(new BitmapDrawable(
								getResources(), BitmapFactory
								.decodeStream(getAssets().open(
										section.imagePath))));
					}

					mRootLayout.addView(touch);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String getContentOfFile(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		is.close();

		return sb.toString();
	}
}
