
public class UserService {
	public User createUser(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
}
