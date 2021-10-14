package com.userlogin;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
				User user = new User(dataLine);
				user.setUserName(dataLine[0]);
				user.setPassword(dataLine[1]);
				user.setName(dataLine[2]);
				user.setRole(dataLine[3]);
				users[userCtr] = user;
				SortUsers sortUsers = new SortUsers();
				sortUsers.superUsers(user);
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
		System.out.println("there should be users");
		return users;
}

}

