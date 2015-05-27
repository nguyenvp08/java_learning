package com.example.javalearning.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Lessions {

	@SerializedName("lessions")
	public List<Lesson> data;
	
	public static class Lesson implements Serializable {
		
		@SerializedName("id")
		public int id;
	
		@SerializedName("chapter_id")
		public int chapterId;
		
		@SerializedName("lession_type")
		public int lessionType;
		
		@SerializedName("order")
		public int order;
		
		@SerializedName("question_id")
		public int questionId;
	}
}
