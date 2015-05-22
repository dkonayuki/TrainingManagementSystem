package com.rakuten.PenguinSoldiers.util;

public class ViewUtil {
	
	public static String html2text(String html) {
    return html.replaceAll("\\<[^>]*>","");
	}
	
}

