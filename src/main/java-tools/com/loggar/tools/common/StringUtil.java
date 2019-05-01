package com.loggar.tools.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtil {
	public static final String SYSTEM_LINE_SEPARATER = System.getProperty("line.separator");
	private static final String default_array_delimiter = ",";

	private StringUtil() {
		throw new AssertionError();
	}

	public static String toString(String[] arr_s) {
		return toString(arr_s, ",");
	}

	public static String toString(String[] arr_s, String delimiter) {
		if (isEmpty(delimiter)) delimiter = default_array_delimiter;

		StringBuffer sb = new StringBuffer();
		sb.setLength(0);

		int length = arr_s.length;

		for (int i = 0; i < length; i++) {
			sb.append(arr_s[i]).append(delimiter);
		}

		String result = sb.toString();

		return result.substring(0, result.length() - delimiter.length());
	}

	public static boolean isContained(String target, String[] arr) {
		boolean result = false;

		for (String s : arr) {
			if (target.equals(s)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static boolean isEmpty(String target) {
		if (target == null) return true;
		if (target.trim().length() == 0) return true;
		return false;
	}

	public static boolean isEmpty(Object t) {
		if (t == null) return true;
		String target;
		try {
			target = (String) t;
		} catch (Exception e) {
			return true;
		}
		if (target.trim().length() == 0) return true;
		return false;
	}

	public static boolean isNotEmpty(String target) {
		if (target == null) return false;
		if (target.trim().length() < 1) return false;
		return true;
	}

	public static String getEmptyIfNull(String s) {
		if (s == null) {
			return "";
		}

		return s;
	}

	public static boolean isEmptyOrStrNull(String s) {
		if (isEmpty(s)) return true;
		if ("null".equals(s.trim().toLowerCase())) return true;
		return false;
	}

	public static <K, V> String debugMap(Map<K, V> map) {
		if (map == null || map.size() < 1) {
			return "{}";
		}

		Set<K> keySet = map.keySet();

		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (K key : keySet) {
			sb.append(SYSTEM_LINE_SEPARATER).append("  ").append(key).append(": ").append(map.get(key)).append(", ");
		}

		String result = sb.toString();
		if (result.length() > 2) {
			return result.substring(0, result.length() - 2) + SYSTEM_LINE_SEPARATER + "}";
		} else {
			return "{}";
		}
	}

	public static <T> String debugList(List<T> list) {
		return debugList(list, false);
	}

	public static <T> String debugList(List<T> list, boolean newLine) {
		if (list == null || list.size() < 1) {
			return "[]";
		}

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (newLine) sb.append(SYSTEM_LINE_SEPARATER);

		for (T e : list) {
			sb.append(e.toString());
			if (newLine) sb.append(SYSTEM_LINE_SEPARATER);
		}

		String r = sb.toString();
		if (r.length() > 2) {
			String r2 = r.substring(0, r.length() - 2);
			if (newLine) r2 = r2 + SYSTEM_LINE_SEPARATER;
			return r2 + "]";

		} else {
			return "[]";
		}
	}

	public static String join(String delimiter, String[] a) {
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		for (String s : a) {
			if (sb.length() > 0) sb.append(delimiter);
			sb.append(s);
		}
		return sb.toString();
	}

	public static String join(String delimiter, List<String> a) {
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		for (String s : a) {
			if (sb.length() > 0) sb.append(delimiter);
			sb.append(s);
		}
		return sb.toString();
	}

	public static char charLowerCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (char) ((int) c + 32);
		} else {
			return c;
		}
	}

	public static char charUpperCase(char c) {
		if (c >= 'a' && c <= 'z') {
			return (char) ((int) c - 32);
		} else {
			return c;
		}
	}

	/**
	 * <pre>
	 * Fill Zero value
	 * zeroFill(1380,7) = 0001380
	 * </pre>
	 *
	 * @param seqno
	 * @param size
	 * @return
	 */
	public static String zeroFill(int seqno, int size) {
		StringBuffer convert = new StringBuffer();
		int maxSize = (int) Math.pow(10, size); // if size=5 then maxSize=100,000

		if (seqno >= maxSize) {
			convert.append(Integer.toString(maxSize - 1));
		} else {
			int seqnoSize = (Integer.toString(seqno)).length();
			for (int i = 0; i < (size - seqnoSize); i++) {
				convert.append("0");
			}
			convert.append(seqno);
		}
		return convert.toString();
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static int parseInt(String arg) {
		if (isEmpty(arg) || !isNumeric(arg)) {
			return 0;
		} else {
			return Integer.parseInt(arg);
		}
	}

	public static double parseDouble(String arg) {
		if (isEmpty(arg) || !isNumeric(arg)) {
			return 0;
		} else {
			return Double.parseDouble(arg);
		}
	}

	public static long parseLong(String arg) {
		if (isEmpty(arg) || !isNumeric(arg)) {
			return 0;
		} else {
			return Long.parseLong(arg);
		}
	}

	public static float parseFloat(String arg) {
		if (isEmpty(arg) || !isNumeric(arg)) {
			return 0;
		} else {
			return Float.parseFloat(arg);
		}
	}
}
