import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
// 		initializing objects
		User user = new User();
		boolean correctLogin = false;
		Scanner scanner = new Scanner(System.in);
		BufferedReader fileReader = null;
		boolean badInput = false;
		
		for (int i = 0; i < 5; i++) {
			if (correctLogin == true) {
				break;
			}
			if (badInput == true) {
				System.out.println("Invalid login, please try again");
			}
//		user input
			System.out.println("Enter your email:");
			String inputUserName= scanner.next().toLowerCase();

			System.out.println("Enter your password:");
			String inputPassword = scanner.next();

			UserService userService = new UserService();
			userService.createUser(inputUserName, inputPassword);
//		file reading

			try {
				fileReader = new BufferedReader(new FileReader("data.txt"));
				String line;
				while ((line = fileReader.readLine()) != null) {
					if (correctLogin == true) {
						break;
					}
					String[] dataLine = new String[4];
					dataLine = line.split(",");
					user.setUserName(dataLine[0]);
					user.setPassword(dataLine[1]);
					user.setName(dataLine[2]);
					
//				Handling login attempts
					if (inputUserName.equals(user.getUserName()) && inputPassword.equals(user.getPassword())) {
						correctLogin = true;
						break;
					} else {
						badInput = true;
					}
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			} finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.out.println("There was an I/O error!");
					e.printStackTrace();
				}
			}
		}
		if (correctLogin) {
			System.out.println("Welcome: " + user.getName());
			scanner.close();
		} else if (correctLogin == false){
				System.out.println("Too many failed login attempts, you are now locked out.");
				scanner.close();
		}

	}
}
