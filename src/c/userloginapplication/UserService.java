package c.userloginapplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserService {
	Scanner scanner = new Scanner(System.in);
	private User[] users = new User[4];

	public String askUser(String question) {
		System.out.println(question);
		return scanner.next();
	}

	public int userGuiSelector(String gui) {
		System.out.println(gui);
		return scanner.nextInt();
	}

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

	public User getUserByUserName(String otherUserSelected, Boolean isSuperUser, boolean loggedInUser) {
		for (User user : users) {
			if (otherUserSelected.equalsIgnoreCase(user.getUserName())) {
				if (user != null) {
					if (user.getRole().equals("super_user")) {
						System.out.println("Welcome Super user " + user.getName());
						isSuperUser = true;
						userOptions(user, isSuperUser, loggedInUser);
					} else {
						System.out.println("Welcome " + user.getName());
						isSuperUser = false;
						userOptions(user, isSuperUser, loggedInUser);
					}
					System.out.println("user select error");
					return user;
				}
			}
		}
		return null;
	}

	public void manageLoginAttempts(User user, String userName, UserService userService1, Boolean isSuperUser)
			throws IOException {
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				System.out.println(English.TOO_MANY_ATTEMPTS);
				System.exit(i);
			}
			String inputUserName = userService1.askUser(English.ENTER_EMAIL);
			String inputPassword = userService1.askUser(English.ENTER_PASSWORD);

			user = userService1.getUserByUsernameAndPassword(inputUserName, inputPassword);
			if (user != null) {
				boolean loggedInUser = true;
				if (user.getRole().equals("super_user")) {
					System.out.println("Welcome super user " + user.getName());
					isSuperUser = true;
					userOptions(user, isSuperUser, loggedInUser);
				} else if (user.getRole().equals("normal_user")) {
					System.out.println("Welcome normal user " + user.getName());
					userOptions(user, isSuperUser, loggedInUser);
				}
				break;
			} else {
				System.out.println(English.INVALID_LOGIN);
			}
			continue;
		}
	}

	public void userOptions(User user, Boolean isSuperUser, boolean loggedInUser) {
		while (loggedInUser) {
			if (isSuperUser) {
				int superUserSelector = userGuiSelector(English.SUPER_USER_GUI);
				switch (superUserSelector) {
				case 0:
					try {
						String otherUserSelected = askUser(English.CHANGE_USER);
						setUsers(FileInput.populateUsersFromFile(FileInterface.standardFileName));
						getUserByUserName(otherUserSelected, isSuperUser, loggedInUser);
					} catch (IOException e) {
						System.out.println("SuperUser case 0 error.");
						e.printStackTrace();
					}

					break;
				case 1:
					String changeUsername = askUser(English.UPDATE_USER_NAME);
					user.setUserName(changeUsername);
					try {
						Arrays.sort(users);
						FileOutputClass.writeFile(users);
					} catch (IOException e) {
						System.out.println("SuperUser case 1 error.");
						e.printStackTrace();
					}
					break;
				case 2:
					String changePassword = askUser(English.UPDATE_PASSWORD);
					user.setPassword(changePassword);
					try {
						Arrays.sort(users);
						FileOutputClass.writeFile(users);
					} catch (IOException e) {
						System.out.println("SuperUser case 2 error.");
						e.printStackTrace();
					}
					break;
				case 3:
					String changeName = askUser(English.UPDATE_NAME);
					user.setName(changeName);
					try {
						Arrays.sort(users);
						FileOutputClass.writeFile(users);	
					}catch (IOException e) {
						System.out.println("SuperUser case 3 error.");
						e.printStackTrace();
					}
					break;
				case 4:
					System.exit(1);

				default:
					System.out.println(English.INVALID_SUPER_USER_SELECTION);
					return;
				}
			} else if (isSuperUser == false) {
				int normalUserSelector = userGuiSelector(English.NORMAL_USER_GUI);
				switch (normalUserSelector) {
				case 1:
					String changeUsername = askUser(English.UPDATE_USER_NAME);
					System.out.println(user.getUserName());
					user.setUserName(changeUsername);
					try {
						Arrays.sort(users);
						FileOutputClass.writeFile(users);
					} catch (IOException e) {
						System.out.println("NormalUser case 1 error.");
						e.printStackTrace();
					}
					break;
				case 2:
					String changePassword = askUser(English.UPDATE_PASSWORD);
					user.setPassword(changePassword);
					try {
						Arrays.sort(users);
						FileOutputClass.writeFile(users);
					} catch (IOException e) {
						System.out.println("NormalUser case 2 error.");
						e.printStackTrace();
					}
					break;
				case 3:
					String changeName = askUser(English.UPDATE_NAME);
					user.setName(changeName);
					try {
						Arrays.sort(users);
						FileOutputClass.writeFile(users);

					} catch (IOException e) {
						System.out.println("NormalUser case 3 error.");
						e.printStackTrace();
					}
					break;
				case 4:
					System.exit(1);
				default:
					System.out.println(English.INVALID_NORMAL_USER_SELECTION);
					break;
				}
			}
		}
	}

	public String getCurrentUser(User user) {
		return user.getUserName() + ", " + user.getPassword() + ", " + user.getName() + ", " + user.getRole() + "\n";
	}
}
