package com.loggar.io.rw;

public class FileUtil {
	/**
	 * extract file extension name from file name
	 * @param fileName
	 * @return file extension str
	 */
	public static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf('.') +1);
	}
	
	/**
	 * extract file extension name from file name
	 * @param fileName
	 * @return file extension char array
	 */
	public static char [] getFileExtension(char [] fileName) {
		String strFileName = new String(fileName);
		return strFileName.substring(strFileName.lastIndexOf('.') +1).toCharArray();
	}
}
