package com.userlogin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileOutputClass {

	public static void FileOutput() throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("data.txt"));
			writer.write("here is a line\n");
			writer.write("here is 2 a line\n");
			writer.write("here is 3 a line\n");
		} finally {
			if (writer != null)
				writer.close();
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			for (int i = 0; i < 5; i++) {
				while (reader != null) {
				System.out.println(reader.readLine());
				break;
				}
				
			}

		} finally {
			if (reader != null) reader.close();
		}
	}
}
