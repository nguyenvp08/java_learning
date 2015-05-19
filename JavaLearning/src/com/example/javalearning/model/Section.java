package com.example.javalearning.model;

import com.google.gson.annotations.SerializedName;

public class Section {
	
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
