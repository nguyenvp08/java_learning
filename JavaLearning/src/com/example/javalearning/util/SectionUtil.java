package com.example.javalearning.util;

import java.util.ArrayList;
import java.util.List;

import com.example.javalearning.model.Lessions.Lesson;
import com.example.javalearning.model.Sections;
import com.example.javalearning.model.Sections.Section;

public class SectionUtil {
	
	public static List<Section> findSectionOfLesson(Lesson lesson, Sections sections) {
		List<Section> resultSections = new ArrayList<Sections.Section>();
		if (sections.sectionList != null) {
			for (Section section : sections.sectionList) {
				if (section.sectionId == lesson.id) {
					resultSections.add(section);
				}
			}
		}
		
		return resultSections;
	}
}
