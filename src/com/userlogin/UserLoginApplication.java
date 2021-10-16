package com.userlogin;
import java.io.IOException;


public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
// 		initializing objects
		User user = null;
		UserService userService1 = new UserService();
		Boolean isSuperUser = false;
		Boolean initialLogin = true;
		
		
		userService1.setUsers(FileService.populateUsersFromFile(FileInterface.standardFileName));
		userService1.manageLoginAttempts(user, userService1, isSuperUser, initialLogin);
		userService1.userOptions(user, isSuperUser, initialLogin);
	}
}
