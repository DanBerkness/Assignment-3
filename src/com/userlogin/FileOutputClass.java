package com.userlogin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class FileOutputClass {
	public static void writeFile(User[] users) throws IOException {
		BufferedWriter writer = null;
		UserService userService1 = new UserService();
		
		try {
			writer = new BufferedWriter(new FileWriter(FileInterface.standardFileName));
			

			for (User user : users) {
				
				writer.write(userService1.getCurrentUser(user));
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
