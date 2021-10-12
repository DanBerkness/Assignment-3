package com.userlogin;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
// 		initializing objects
		User loggedInUser = null;
		UserService userService1 = new UserService();
		English english = new English();
		
		
		userService1.setUsers(FileService.populateUsersFromFile(FileInterface.standardFileName));
		userService1.manageLoginAttempts(english, loggedInUser);
//		NOW WE HAVE A USER!!!
		
	}
}
