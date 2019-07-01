package com.loggar.tools.image;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class ImageServiceTest {
	@Test
	public void resize() {
		int maxWidth = 200;
		
		String orgPath = "./dist/image/testImage.jpg";
		String newPath = orgPath.subSequence(0, orgPath.lastIndexOf('.')) + "_new.jpg";
		
		boolean result = false;
		
		ImageService imageService = new ImageService();
		
		try {
			result = imageService.resizeWidth(maxWidth, orgPath, newPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertThat(result, is(true));
	}
}
