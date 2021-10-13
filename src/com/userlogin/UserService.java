package com.userlogin;

import java.io.IOException;
import java.util.Scanner;

public class UserService {
	Scanner scanner = new Scanner(System.in);

	public String askUser(String question) {
		System.out.println(question);
		return scanner.next();
	}

	public int userGuiSelector(String gui) {
		System.out.println(gui);
		return scanner.nextInt();
	}

	private User[] users = new User[4];

	public User createUser(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		for (User user : users) {
			if (username.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	public void manageLoginAttempts(English english, User loggedInUser) throws IOException {

		UserService userService1 = new UserService();

		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				System.out.println(english.tooManyAttempts);
				System.exit(i);
			}
			String inputUserName = userService1.askUser(english.enterEmail);
			String inputPassword = userService1.askUser(english.enterPassword);

			loggedInUser = userService1.getUserByUsernameAndPassword(inputUserName, inputPassword);
			if (loggedInUser != null) {
				System.out.println("Welcome" + loggedInUser.getName());
				break;
			} else {
				System.out.println(english.invalidLogin);
			}
			continue;
			}	
	}

	
	if (user.getRole().equals("super_user")) {
		int superUserSelector = userService.userGuiSelector(language.superUserGui);
			switch (superUserSelector) {
			
			case 0: String otherUserSelected = userService.askUser(language.changeUser);	
//				compare username to all of the users in the list. change to that user.
			case 1: String changeUsername = userService.askUser(language.updateUserName);
//			overwrite method.
			case 2: String changePassword = userService.askUser(language.upatePassword);
//			overwrite method on password
			case 3: String changeUserName = userService.askUser(language.updateName);
//			Overwrite method on name
			case 4: System.exit(1);
			default: System.out.println(language.invalidSelection);
				return;
			}
		}else {
			int normalUserSelector = userService.userGuiSelector(language.normalUserGui);
			switch (normalUserSelector) {
			case 1: String changeUsername = userService.askUser(language.updateUserName);
//			overwrite method.
			case 2: String changePassword = userService.askUser(language.upatePassword);
//			overwrite method on password
			case 3: String changeUserName = userService.askUser(language.updateName);
//			Overwrite method on name
			case 4: System.exit(1);
			default: System.out.println(language.invalidSelection);
				return;
			}
		}
}

