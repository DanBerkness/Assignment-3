package c.userloginapplication;

public class SuperUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperUser(String userName, String password, String name) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setName(name);
		this.role = "super_user";
	}
}
