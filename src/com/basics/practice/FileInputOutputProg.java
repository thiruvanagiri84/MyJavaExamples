package com.basics.practice;

import java.io.File;
import java.io.IOException;

public class FileInputOutputProg {
	public static void main(String[] x){
		
		//Creating File with text content using PrintWriter 
		UtilityProg.createFile("C:\\Santosh\\Personal\\JAVA\\Waste\\sample1.txt");
		
		//Creating File with text content using BufferedWriter
		try {
			UtilityProg.writeContentToFile("C:\\Santosh\\Personal\\JAVA\\Waste\\sample2.txt", "This is Sample2 text file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File source = new File("C:\\Santosh\\Personal\\JAVA\\Waste\\sample3.txt");
		File dest = new File("C:\\Santosh\\Personal\\JAVA\\Waste\\sample4.txt");
		
		// copy file using FileStreams
		long start;
		long end;
		System.out.println("Writing starts");
		start = System.nanoTime();
        UtilityProg.copyFileUsingFileStreams(source, dest);
        end = System.nanoTime();
        System.out.println("Time taken by FileStreams Copy = "+ (end - start));
        
		// copy file using FileStreams
		start = System.nanoTime();
		System.out.println("Writing starts");
        try {
			UtilityProg.copyFileUsingFileChannels(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
        end = System.nanoTime();
        System.out.println("Time taken by FileStreams Copy = "+ (System.nanoTime() - start));
        
		// copy file using FileStreams
        /*start = System.nanoTime();
		System.out.println("Writing starts");
        try {
			UtilityProg.copyFileUsingJava7Files(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
        end = System.nanoTime();
        System.out.println("Time taken by FileStreams Copy = "+ (System.nanoTime() - start));*/
        
	}
	
	
}
