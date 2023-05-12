package com.gmail.inglese.giustiniano.utils;
import java.text.SimpleDateFormat;

public interface Costants {

	static final String yearFormat = "yyyy";
	public static final SimpleDateFormat sdf = new SimpleDateFormat(Costants.yearFormat); 
	static final String formatDMY = "dd/mm/yyyy";
	public static final SimpleDateFormat sdfday = new SimpleDateFormat(Costants.formatDMY);
	
}
