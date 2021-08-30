import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
// 		initializing objects
		User loggedInUser = null;
		Scanner scanner = new Scanner(System.in);
		UserService userService1 = new UserService();
		userService1.setUsers(FileService.populateUsersFromFile("data.txt"));

		for (int i = 0; i < 5; i++) {
		
//			user input
			System.out.println("Enter your email:");
			String inputUserName = scanner.next().toLowerCase();

			System.out.println("Enter your password:");
			String inputPassword = scanner.next();

			loggedInUser = userService1.getUserByUsernameAndPassword(inputUserName, inputPassword);
			if (loggedInUser != null) {
				break;
			}else {
				System.out.println("Invalid login, please try again");
			}
		}

		if (loggedInUser != null) {
			System.out.println("Welcome" + loggedInUser.getName());
		}else {
			System.out.println("Too many failed login attempts, you are now locked out.");
			scanner.close();
		}
		
	}
}
