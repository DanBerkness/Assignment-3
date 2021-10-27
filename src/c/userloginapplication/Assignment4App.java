package c.userloginapplication;
import java.io.IOException;


public class Assignment4App {

	public static void main(String[] args) throws IOException {

		User user = null;
		UserService userService1 = new UserService();
		Boolean isSuperUser = false;
		String userName = null;
		boolean loggedInUser = false;
		
		userService1.setUsers(FileInput.populateUsersFromFile(FileInterface.standardFileName));
		userService1.manageLoginAttempts(user, userName, userService1, isSuperUser);
		userService1.userOptions(user, isSuperUser, loggedInUser);
	}
}
