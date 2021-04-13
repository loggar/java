package com.loggar.io.rw;

public interface FileInOutSimple {
	public void write(String filePath, Object data);

	public String read(String filePath);
}
