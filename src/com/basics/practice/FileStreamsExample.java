package com.basics.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Reading a File and copying its contents to another File
 */
public class FileStreamsExample {
	public static void main(String[] x){
		FileInputStream sourceFile = null;
		FileOutputStream destFile = null;
		
		int bytes_read = 0;
		byte[] buffer = new byte[8];
		
		try{
			sourceFile = new FileInputStream("C:\\Santosh\\test.txt");
			destFile = new FileOutputStream("C:\\Santosh\\test2.txt");
			
			/*while( (bytes_read = sourceFile.read(buffer)) != -1){
				destFile.write(buffer, 0, bytes_read);
			}*/
			
			while(true){
				bytes_read = sourceFile.read(buffer);
				if(bytes_read == -1){
					break;
				}else{
					destFile.write(buffer, 0, bytes_read);
				}
			}
			System.out.println("Writing to file complete");
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				sourceFile.close();;
				destFile.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
