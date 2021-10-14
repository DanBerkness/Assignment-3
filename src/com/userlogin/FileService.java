package com.userlogin;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public static User[] populateUsersFromFile(String filepath) throws IOException { 
		User[] users = null;
		BufferedReader fileReader = null;
		int userCtr = 0;
		try {
			fileReader = new BufferedReader(new FileReader(filepath));
			String line;
			users = new User[20];
			while ((line = fileReader.readLine()) != null) {
				String[] dataLine = new String[4];
				dataLine = line.split(", ");
				User newUser = new User(dataLine);
				users[userCtr] = newUser;
				userCtr++;
			}
		
	} catch (FileNotFoundException e) {
		System.out.println("File not found!");
	} finally {
		try {
			fileReader.close();
		} catch (IOException e) {
			System.out.println("There was an I/O error!");
			e.printStackTrace();
		}
	}
		return users;
}

}

