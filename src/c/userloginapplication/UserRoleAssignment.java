package c.userloginapplication;

import java.util.Arrays;

public class UserRoleAssignment {
	public void sortUsers(User user, String[] dataLine, User[] users, int userCtr) {

		if (user.getRole().equals("super_user")) {
			users[userCtr++] = new SuperUser(dataLine[0], dataLine[1], dataLine[2]);
//			Arrays.sort(users);

			Boolean isSuperUser = true;
		} else {
			users[userCtr++] = new NormalUser(dataLine[0], dataLine[1], dataLine[2]);
//			Arrays.sort(users);
			Boolean isSuperUser = false;
		}

	}

}
