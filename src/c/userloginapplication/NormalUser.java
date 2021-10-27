package c.userloginapplication;

public class NormalUser extends User{
	public NormalUser(String userName, String password, String name) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setName(name);
		this.role = "normal_user";
	}
}
