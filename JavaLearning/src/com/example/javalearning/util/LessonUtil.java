package com.example.javalearning.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.javalearning.model.Chapters.Chapter;
import com.example.javalearning.model.Lessions;
import com.example.javalearning.model.Lessions.Lesson;

public class LessonUtil {

	public static List<Lesson> findLessonOfChapter(Chapter chapter, Lessions lessons) {
		List<Lesson> resultSections = new ArrayList<Lesson>();
		if (lessons.data != null) {
			for (Lesson lesson : lessons.data) {
				if (lesson.chapterId == chapter.id) {
					resultSections.add(lesson);
				}
			}
		}
		
		Collections.sort(resultSections, new LessonComparator());
		return resultSections;
	}
	
	private static class LessonComparator implements Comparator<Lesson> {

		@Override
		public int compare(Lesson lhs, Lesson rhs) {
			return lhs.order - rhs.order;
		}
	}
}
