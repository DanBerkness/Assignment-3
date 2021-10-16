package com.userlogin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class FileOutputClass {

	public static void FileOutput(User[] users) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (User user : users) {
//			sb = sb + user;
		
			
		}
		try (FileOutputStream fileOutput = new FileOutputStream(FileInterface.standardFileName);
				ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
			objectOutput.writeObject(sb.toString());
			
		}
	}
}
