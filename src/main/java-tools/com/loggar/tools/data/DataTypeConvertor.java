package com.loggar.tools.data;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.loggar.tools.common.StringUtil;

public class DataTypeConvertor {
	private DataTypeConvertor() {
		throw new AssertionError(StringUtil.class.getName() + " cannot be instantiable.");
	}

	public static byte[] convertBase64ToBinary(String strBase64) {
		byte[] decodedString = null;
		try {
			byte[] r = Base64.getEncoder().encode(strBase64.getBytes());
			decodedString = Base64.getDecoder().decode(new String(r).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return decodedString;
	}

	public static byte[] convertBase64ImageToBinary(String base64Image) {
		byte[] decodedString = null;
		try {
			decodedString = Base64.getDecoder().decode(new String(base64Image.substring(base64Image.indexOf(",") + 1)).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return decodedString;
	}
}
