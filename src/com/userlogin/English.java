package com.userlogin;

public class English {
//	This code MAY wipe user
	User user = new User();
		
		String enterEmail = "Enter your email: ";
		String enterPassword = "Enter your password";
		String welcomeUser = "Welcome " + user.getName();
		String tooManyAttempts = "Too many failed login attempts, you are now locked out.";
		String superUserGui = "Please choose from the following options:\r\n"
				+ "\r\n"
				+ "(0) Log in as another user\r\n"
				+ "\r\n"
				+ "(1) Update username\r\n"
				+ "\r\n"
				+ "(2) Update password\r\n"
				+ "\r\n"
				+ "(3) Update name\r\n"
				+ "\r\n"
				+ "(4) Exit";
		String normalUserGui = "Please choose from the following options:\r\n"
				+ "\r\n"
				+ "(1) Update username\r\n"
				+ "\r\n"
				+ "(2) Update password\r\n"
				+ "\r\n"
				+ "(3) Update name\r\n"
				+ "\r\n"
				+ "(4) Exit";
		String changeUser = "Which user would you like to login as? (Type in a valid username)";
		String updateName = "Please type in your new name:";
		String upatePassword = "Please type in your new password:";
		String updateUserName = "Please type in your new username:";
		String invalidLogin = "Invalid login, please try again.";
		String invalidSelection = "Please enter a number between 1 and 4:";
		
}
