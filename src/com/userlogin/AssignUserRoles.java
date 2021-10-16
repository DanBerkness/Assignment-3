package com.userlogin;

import java.util.Arrays;

public class AssignUserRoles {
	public void superUsers(User user, String[] dataLine, User[] users, int userCtr) {
		
		if (user.getRole().equals("super_user")) {
			users[userCtr++]= new SuperUser(dataLine[0], dataLine[1], dataLine[2]);
			Arrays.sort(dataLine);
		}else {
			users[userCtr++]= new NormalUser(dataLine[0], dataLine[1], dataLine[2]);
			Arrays.sort(dataLine);
		}
		
	} 
}
