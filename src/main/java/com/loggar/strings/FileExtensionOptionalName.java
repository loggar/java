package com.loggar.strings;

import java.util.Optional;

public class FileExtensionOptionalName {
	public static Optional<String> getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains(".")).map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
}
