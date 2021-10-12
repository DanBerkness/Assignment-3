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

}
