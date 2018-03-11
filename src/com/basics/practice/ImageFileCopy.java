package com.basics.practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageFileCopy {
	public static void main(String[] x)throws IOException{
		int width = 963;
		int height = 640;
		BufferedImage buffImage = null;
		File f = null;
		
		//Reading an Image
		try{
			f = new File("C:\\Santosh\\Personal\\JAVA\\Waste\\kohli.jpg");
			buffImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
			buffImage = ImageIO.read(f);
			System.out.println("Reading of image is completed");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		//Writing an Image
		try{
			f = new File("C:\\Santosh\\Personal\\JAVA\\Waste\\kohli_output.jpg");
			ImageIO.write(buffImage,"jpg", f);
			System.out.println("Writing of image is completed");
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
}
