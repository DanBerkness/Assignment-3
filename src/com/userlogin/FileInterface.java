package com.userlogin;
import java.io.File;

public interface FileInterface {
	String standardFileName = "users.txt";
	String readLine (File file);
	void writeLine(File file,String line);
}
