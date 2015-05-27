package com.example.javalearning;

import java.io.IOException;
import java.util.List;

import com.example.javalearning.model.Sections;
import com.example.javalearning.model.Lessions.Lesson;
import com.example.javalearning.model.Sections.Section;
import com.example.javalearning.util.Constants;
import com.example.javalearning.util.SectionUtil;
import com.example.javalearning.util.StoreUtil;
import com.example.javalearning.view.ConsolaContentView;
import com.example.javalearning.view.FitWidthImageView;
import com.example.javalearning.view.NoteView;
import com.example.javalearning.view.TextContentView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LessionActivity extends Activity {
	
	private LinearLayout mRootLayout;
	private Lesson mLesson;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_lession);
		parseIntent(getIntent());
		initViews();
	}
	
	private void parseIntent(Intent intent) {
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			mLesson = (Lesson) intent.getSerializableExtra(Constants.EXTRA_LESSON_DATA);
		}
	}

	private void initViews() {
		mRootLayout = (LinearLayout) findViewById(R.id.layout_root);
		Sections sections = StoreUtil.mSections;
		List<Section> sectionList = SectionUtil.findSectionOfLesson(mLesson, sections);
		for (Section section : sectionList) {
			if (section.mediaType == 1) {
				TextContentView contentView = new TextContentView(this);
				mRootLayout.addView(contentView);
				contentView.setText(section.text);
			}
			
			if (section.mediaType == 2) {
				ConsolaContentView contentView = new ConsolaContentView(this);
				mRootLayout.addView(contentView);
				contentView.setText(section.text);
			}

			if (section.mediaType == 3) {
				ImageView touch = new FitWidthImageView(this);
				try {
					LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
							LayoutParams.MATCH_PARENT,
							LayoutParams.WRAP_CONTENT);
					param.setMargins(16, 0, 16, 16);
					touch.setLayoutParams(param);
					touch.setTag(section.imagePath);
					touch.setAdjustViewBounds(true);
					
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
			
			if (section.mediaType == 4) {
				NoteView noteView = new NoteView(this);
				mRootLayout.addView(noteView);
				noteView.setText(section.text);
			}
		}
	}
}
