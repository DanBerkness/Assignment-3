package com.userlogin;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
// 		initializing objects
		User user = null;
		UserService userService1 = new UserService();
		
		
		
		userService1.setUsers(FileService.populateUsersFromFile(FileInterface.standardFileName));
		userService1.manageLoginAttempts(user, userService1);
		userService1.userOptions(user);
		System.out.println(isSuper);
	}
}
