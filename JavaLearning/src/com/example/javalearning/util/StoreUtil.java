package com.example.javalearning.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.AssetManager;

import com.example.javalearning.model.Chapters;
import com.example.javalearning.model.Lessions;
import com.example.javalearning.model.Sections;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StoreUtil {
	public static Sections mSections;
	public static Chapters mChapters;
	public static Lessions mLessions;
	
	public static void loadContent(AssetManager asset) throws IOException {
		Gson gson = new GsonBuilder().create();
		
		String chapters = getContentOfFile(asset.open("chapters.xml"));
		String sections = getContentOfFile(asset.open("sections.xml"));
		String lessions = getContentOfFile(asset.open("lessons.xml"));
		
		mSections = gson.fromJson(sections, Sections.class);
		mChapters = gson.fromJson(chapters, Chapters.class);
		mLessions = gson.fromJson(lessions, Lessions.class);
	}
	
	private static String getContentOfFile(InputStream is) throws IOException {
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
