package com.shavika.foodies.common.utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProcess {

	private static String desc_imageDirectory = "D:\\1.mboraiah\\1.SHAVIKA\\Development\\foodie_application\\sourceCode\\github-backup\\foodiesV3\\src\\main\\webapp\\resources\\assets\\menuimage\\";
	private static String src_imageDirectory = "D:\\1.mboraiah\\1.SHAVIKA\\Development\\foodie_application\\sourceCode\\github-backup\\foodiesV3\\src\\main\\webapp\\resources\\assets\\image\\user_female.png";

	public static byte[] image2bytearray(String filename) {
		File file = new File(filename);
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for (int readnum; (readnum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readnum);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
		}
		return bos.toByteArray();
	}

	
	public static void bytearray2image(byte[] imagearray) {
		try {
			BufferedImage imag = ImageIO.read(new ByteArrayInputStream(imagearray));
			ImageIO.write(imag, "png", new File(desc_imageDirectory,"copy.png"));        

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		byte[] imageary = image2bytearray(src_imageDirectory);
		bytearray2image(imageary);
		System.out.println("Done.........");
	}

}
