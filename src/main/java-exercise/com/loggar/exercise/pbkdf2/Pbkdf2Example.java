package com.loggar.exercise.pbkdf2;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Pbkdf2Example {
	public static void main(String[] args) throws UnsupportedEncodingException {

		String password = "pass";
		String salt = "1234";
		int iterations = 10000;
		int keyLength = 512;
		char[] passwordChars = password.toCharArray();
		byte[] saltBytes = salt.getBytes();

		byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
		String hashedString = Hex.encodeHexString(hashedBytes);

		System.out.println(hashedString);
	}

	public static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength) {

		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}
}