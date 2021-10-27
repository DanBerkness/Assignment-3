package c.userloginapplication;
import java.io.File;

public interface FileInterface {
	String standardFileName = "src/users.txt";
	String readLine (File file);
	void writeLine(File file,String line);
}
