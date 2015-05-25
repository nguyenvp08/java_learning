package com.example.javalearning.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Chapters {

	@SerializedName("chapters")
	public List<Chapter> data;
	
	public static class Chapter {
		@SerializedName("id")
		public int id;
		@SerializedName("name")
		public String name;
		@SerializedName("description")
		public String description;
	}
}
