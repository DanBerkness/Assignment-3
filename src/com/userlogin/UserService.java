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
				}else if (isSuperUser == false)
				break;
			} else {
				System.out.println(English.INVALID_LOGIN);
			}
			continue;
		}
	}

	public void userOptions(User user, Boolean isSuperUser) {
		if (isSuperUser == true ) {
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
					user.setUserName(changeUsername);
					try {
						FileOutputClass.writeFile(users);
						return;
					} catch (IOException e) {
						System.out.println("Output not working");
						e.printStackTrace();
					}
			case 2:
				String changePassword = askUser(English.UPDATE_PASSWORD);
				user.setPassword(changePassword);
				try {
					FileOutputClass.writeFile(users);
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}
				break;
			case 3:
				String changeName = askUser(English.UPDATE_USER_NAME);
				user.setName(changeName);
				try {
					FileOutputClass.writeFile(users);
					System.out.println("Welcome " + changeName);
					System.out.println(isSuperUser);
					if (isSuperUser) {
						return;
					}
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}
				break;
			case 4:
				System.exit(1);

			default:
				System.out.println(English.INVALID_SUPER_USER_SELECTION);
				return;
			}
		} else if (isSuperUser == false){
			int normalUserSelector = userGuiSelector(English.NORMAL_USER_GUI);
			switch (normalUserSelector) {
			case 1:
				String changeUsername = askUser(English.UPDATE_USER_NAME);
				user.setUserName(changeUsername);
				try {
					FileOutputClass.writeFile(users);
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}				break;
			case 2:
				String changePassword = askUser(English.UPDATE_PASSWORD);
				user.setPassword(changePassword);
				try {
					FileOutputClass.writeFile(users);
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}				break;
			case 3:
				String changeName = askUser(English.UPDATE_NAME);
				user.setName(changeName);
				try {
					FileOutputClass.writeFile(users);
				
					
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}
				return;
			case 4:
				System.exit(1);
			default:
				System.out.println(English.INVALID_NORMAL_USER_SELECTION);
				return;
			}
		}
	}
	public String getCurrentUser(User user) {
		return user.getUserName() + ", " + user.getPassword() + ", " + user.getName() + ", " + user.getRole() + "\n";
	}
}
