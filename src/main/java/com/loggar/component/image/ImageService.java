package com.loggar.component.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.loggar.io.rw.FileUtil;

public class ImageService {
	/**
	 * 
	 * @param maxWidth
	 * @param orgPath full-path
	 * @param newPath full-path
	 * @param ext "jpg"
	 * @return
	 * @throws IOException
	 */
	public boolean resizeWidth(int maxWidth, String orgPath, String newPath, String ext) throws IOException {
		Image orgImg = ImageIO.read(new File(orgPath));
		int width = orgImg.getWidth(null);
		int height = orgImg.getHeight(null);

		if (width > maxWidth) {
			double proportion = ((double) maxWidth) / width;
			int newWidth = (int) maxWidth;
			int newHeight = (int) (height * proportion);

			Image newImg = orgImg.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			BufferedImage brImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			Graphics graphics = brImg.getGraphics();
			graphics.drawImage(newImg, 0, 0, null);
			graphics.dispose();
			ImageIO.write(brImg, ext, new File(newPath));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * image resize with maxWidth value
	 * @param maxWidth
	 * @param orgPath full-path
	 * @param newPath full-path
	 * @return
	 * @throws IOException
	 */
	public boolean resizeWidth(int maxWidth, String orgPath, String newPath) throws IOException {
		return resizeWidth(maxWidth, orgPath, newPath, FileUtil.getFileExtension(newPath));
	}
}
