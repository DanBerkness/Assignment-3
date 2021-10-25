package com.userlogin;
import java.io.IOException;


public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		User user = null;
		UserService userService1 = new UserService();
		Boolean isSuperUser = false;
		SuperUser superUser = new SuperUser(null, null, null);
		NormalUser normalUser = new NormalUser(null, null, null);
		String userName = null;
		
		userService1.setUsers(FIleInput.populateUsersFromFile(FileInterface.standardFileName));
		userService1.manageLoginAttempts(superUser, normalUser, user, userName, userService1, isSuperUser);
		userService1.userOptions(superUser, normalUser, isSuperUser);
	}
}
