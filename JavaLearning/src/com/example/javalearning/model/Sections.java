package com.example.javalearning.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Sections {
	
	@SerializedName("sections")
	public List<Section> sectionList;
	
	public static class Section {
		@SerializedName("id")
		public int id;
		
		@SerializedName("lesson_id")
		public int sectionId;
		
		@SerializedName("media_type")
		public int mediaType;
		
		@SerializedName("text")
		public String text;
		
		@SerializedName("image")
		public String imagePath;
	}

}
