package com.example.javalearning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.javalearning.adapter.ChapterAdapter;
import com.example.javalearning.model.Chapters.Chapter;
import com.example.javalearning.model.Lessions.Lesson;
import com.example.javalearning.util.Constants;
import com.example.javalearning.util.LessonUtil;
import com.example.javalearning.util.StoreUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ChapterActivity extends Activity implements OnItemClickListener {
	
	private ListView mListViewChapter;
	private ChapterAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_chapters);
		initViews();
	}

	private void initViews() {
		try {
			StoreUtil.loadContent(getAssets());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		mListViewChapter = (ListView) findViewById(R.id.listview_chapters);
		mAdapter = new ChapterAdapter(this, StoreUtil.mChapters.data);
		mListViewChapter.setAdapter(mAdapter);
		mListViewChapter.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Chapter currentChapter = StoreUtil.mChapters.data.get(position);
		List<Lesson> lessonArray = LessonUtil.findLessonOfChapter(currentChapter, StoreUtil.mLessions);
		Intent intent = new Intent(this, LessionActivity.class);
		intent.putExtra(Constants.EXTRA_LESSON_DATA, lessonArray.get(0));
		startActivity(intent);
	}
}
