package org.lemonPig.os.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class StringUtils {
	public static boolean isEqual(String textA, String textB) {
		boolean rt = false;
		try {
			rt = textA.equals(textB);
		} catch (NullPointerException e) {
			try {
				rt = textB.equals(textA);
			} catch (NullPointerException e2) {
				rt = true;
			}
		}
		return rt;
	}

	public static boolean isNotBlank(String text) {
		if (text == null || "".equals(text) || "NULL".equalsIgnoreCase(text)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isBlank(String text) {
		return !isNotBlank(text);
	}

	public static String replace(String text, String oldPattern,
			String newPattern) {
		if (!hasLength(text) || !hasLength(oldPattern) || newPattern == null)
			return text;
		StringBuffer sbuf = new StringBuffer();
		int pos = 0;
		int index = text.indexOf(oldPattern);
		int patLen = oldPattern.length();
		for (; index >= 0; index = text.indexOf(oldPattern, pos)) {
			sbuf.append(text.substring(pos, index));
			sbuf.append(newPattern);
			pos = index + patLen;
		}

		sbuf.append(text.substring(pos));
		return sbuf.toString();
	}

	public static boolean hasLength(String text) {
		if (isBlank(text)) {
			return false;
		}
		if (text.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String ioToString(InputStream in, String encoding) {
		StringBuffer content = new StringBuffer();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(in,
					encoding));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String temp = null;
		int i = 0;
		try {
			while ((temp = bufferedReader.readLine()) != null) {
				if (i++ != 0)
					content.append(System.getProperty("line.separator"));
				temp = new String(temp.getBytes(),
						System.getProperty("file.encoding"));
				content.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static String objectToString(Object object) {
		String rt = null;
		try {
			rt = object.toString();
		} catch (NullPointerException e) {
		}
		return rt;
	}

	public static String clean(String in) {
		String out = in;
		if (in != null) {
			out = in.trim();
			if (isBlank(in)) {
				out = null;
			}
		}
		return out;
	}
}
