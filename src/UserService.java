
public class UserService {
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

}
