package com.userlogin;

import java.util.ArrayList;

public class SortUsers {
	public void superUsers(User user) {
		
		if (user.getRole().equals("super_user")) {
			ArrayList superUsers = new ArrayList();
			superUsers.add(user.getName());
			superUsers.add(user.getPassword());
			superUsers.add(user.getUserName());
			superUsers.add(user.getRole());
			System.out.println(superUsers);
			
			
		
			
		}else {
			System.out.println(user.getName() + " Is a normal user");
		}
//		System.out.println(English.NORMAL_USER_GUI);
//		System.out.println(English.SUPER_USER_GUI);
		
	} 
}
