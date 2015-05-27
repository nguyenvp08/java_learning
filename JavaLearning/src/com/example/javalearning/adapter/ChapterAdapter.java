package com.example.javalearning.adapter;

import java.util.List;

import com.example.javalearning.R;
import com.example.javalearning.model.Chapters.Chapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChapterAdapter extends BaseAdapter {

	private Context mContext;
	private List<Chapter> mData;
	
	public ChapterAdapter(Context context, List<Chapter> data) {
		mContext = context;
		mData = data;
	}
	
	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder holder = null;
		if (convertView == null) {
			row = LayoutInflater.from(mContext).inflate(R.layout.layout_chapter_items, null, false);
			holder = new ViewHolder();
			holder.mChapterName = (TextView) row.findViewById(R.id.textView_chapter_name);
			holder.mChapterText = (TextView) row.findViewById(R.id.textView_chapter_text);
			holder.mCurrentLesson = (TextView) row.findViewById(R.id.textView_chapter_current_lesson);
			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}
		
		// inflate data
		Chapter chapter = mData.get(position);
		holder.mChapterName.setText(chapter.description);
		holder.mChapterText.setText(chapter.name);
		holder.mCurrentLesson.setText("Current Lession : 1");
		
		return row;
	}
	
	private static class ViewHolder {
		public TextView mChapterText;
		public TextView mChapterName;
		public TextView mCurrentLesson;
	}
}
