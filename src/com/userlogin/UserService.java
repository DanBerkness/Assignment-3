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


	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public User getUserByUsernameAndPassword(String userName, String password) {
		for (User user : users) {
			if (userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	public User getUserByUserName(String userName, Boolean isSuperUser) {
		for (User user : users) {
			if (userName.equalsIgnoreCase(user.getUserName())) {
				if (user != null) {
					System.out.println("Welcome " + user.getName());
					if (user.getRole().equals("super_user")) {
						isSuperUser = true;
						userOptions(user, isSuperUser);
					} else {
						isSuperUser = false;
						userOptions(user, isSuperUser);
					}
					return user;
				}
			}
		}
		return null;
	}

	public void manageLoginAttempts(User user, UserService userService1, Boolean isSuperUser) throws IOException {
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				System.out.println(English.TOO_MANY_ATTEMPTS);
				System.exit(i);
			}
			String inputUserName = userService1.askUser(English.ENTER_EMAIL);
			String inputPassword = userService1.askUser(English.ENTER_PASSWORD);

			user = userService1.getUserByUsernameAndPassword(inputUserName, inputPassword);
			if (user != null) {
				System.out.println("Welcome " + user.getName());
				if (user.getRole().equals("super_user")) {
					isSuperUser = true;
					userOptions(user, isSuperUser);
				}
				break;
			} else {
				System.out.println(English.INVALID_LOGIN);
			}
			continue;
		}
	}

	public void userOptions(User user, Boolean isSuperUser) {
		if (isSuperUser) {
			int superUserSelector = userGuiSelector(English.SUPER_USER_GUI);
			switch (superUserSelector) {
			case 0:
				String otherUserSelected = askUser(English.CHANGE_USER);
				try {
					setUsers(FileService.populateUsersFromFile(FileInterface.standardFileName));
					getUserByUserName(otherUserSelected, isSuperUser);
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 1:
				String changeUsername = askUser(English.UPDATE_USER_NAME);

				break;
			case 2:
				String changePassword = askUser(English.UPDATE_PASSWORD);
//			overwrite method on password
				break;
			case 3:
				String changeUserName = askUser(English.UPDATE_USER_NAME);
//			Overwrite method on name
				break;
			case 4:
				System.exit(1);

			default:
				System.out.println(English.INVALID_SUPER_USER_SELECTION);
				return;
			}
		} else {
			int normalUserSelector = userGuiSelector(English.NORMAL_USER_GUI);
			switch (normalUserSelector) {
			case 1:
				String changeUsername = askUser(English.UPDATE_USER_NAME);
//			overwrite method.
				break;
			case 2:
				String changePassword = askUser(English.UPDATE_PASSWORD);
//			overwrite method on password
				break;
			case 3:
				String changeUserName = askUser(English.UPDATE_USER_NAME);
//			Overwrite method on name
				break;
			case 4:
				System.exit(1);
			default:
				System.out.println(English.INVALID_NORMAL_USER_SELECTION);
				return;
			}
		}
	}
}
