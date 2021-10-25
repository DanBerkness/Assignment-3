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

	public User getUserByUsernameAndPassword(String inputUserName, String inputPassword) {
		for (User user : users) {
			user.getUserName();
			if (inputUserName.equalsIgnoreCase(user.getUserName()) && inputPassword.equals(user.getPassword())) {
				
				return user;
			}
		}
		return null;
	}

	public User getUserByUserName(SuperUser superUser, NormalUser normalUser, String otherUserSelected, Boolean isSuperUser) {
		for (User user : users) {
			if (otherUserSelected.equalsIgnoreCase(user.getUserName())) {
				if (user != null) {
					if (user.getRole().equals("super_user")) {
						System.out.println("Welcome Super user " + superUser.getName());
						superUser = new SuperUser(superUser.getUserName(), superUser.getPassword(), superUser.getName());
						isSuperUser = true;
						userOptions(superUser, normalUser, isSuperUser);
					} else {
						System.out.println("Welcome " + normalUser.getName());
						isSuperUser = false;
						normalUser = new NormalUser(normalUser.getUserName(), normalUser.getPassword(), normalUser.getName());
						userOptions(superUser, normalUser, isSuperUser);
					}
					return user;
				}
			}
		}
		return null;
	}

	public void manageLoginAttempts(SuperUser superUser, NormalUser normalUser, User user, String userName, UserService userService1, Boolean isSuperUser) throws IOException {
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				System.out.println(English.TOO_MANY_ATTEMPTS);
				System.exit(i);
			}
			String inputUserName = userService1.askUser(English.ENTER_EMAIL);
			String inputPassword = userService1.askUser(English.ENTER_PASSWORD);

			user = userService1.getUserByUsernameAndPassword(inputUserName, inputPassword);
			if (user != null) {
				if (user.getRole().equals("super_user")) {
					System.out.println("Welcome super user " + superUser.getName());
					isSuperUser = true;
					userOptions(superUser, normalUser, isSuperUser);
				}
				else if (user.getRole().equals("normal_user")) {
					userOptions(superUser, normalUser, isSuperUser);
				}
				break;
			} else {
				System.out.println(English.INVALID_LOGIN);
			}
			continue;
		}
	}

	public void userOptions(SuperUser superUser, NormalUser normalUser, Boolean isSuperUser) {
		if (isSuperUser) {
			int superUserSelector = userGuiSelector(English.SUPER_USER_GUI);
			switch (superUserSelector) {
			case 0:
				try {
					String otherUserSelected = askUser(English.CHANGE_USER);
					setUsers(FIleInput.populateUsersFromFile(FileInterface.standardFileName));
					getUserByUserName(superUser, normalUser, otherUserSelected, isSuperUser);
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 1:
					String changeUsername = askUser(English.UPDATE_USER_NAME);
					superUser.setUserName(changeUsername);
					try {
						FileOutputClass.writeFile(users);
					} catch (IOException e) {
						System.out.println("Output not working");
						e.printStackTrace();
					}
				break;
			case 2:
				String changePassword = askUser(English.UPDATE_PASSWORD);
				superUser.setPassword(changePassword);
				try {
					FileOutputClass.writeFile(users);
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}
				break;
			case 3:
				String changeName = askUser(English.UPDATE_USER_NAME);
				superUser.setName(changeName);
				try {
					FileOutputClass.writeFile(users);
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
				normalUser.setUserName(changeUsername);
				try {
					FileOutputClass.writeFile(users);
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}				break;
			case 2:
				String changePassword = askUser(English.UPDATE_PASSWORD);
				normalUser.setPassword(changePassword);
				try {
					FileOutputClass.writeFile(users);
				} catch (IOException e) {
					System.out.println("Output not working");
					e.printStackTrace();
				}				break;
			case 3:
				String changeName = askUser(English.UPDATE_NAME);
				normalUser.setName(changeName);
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
