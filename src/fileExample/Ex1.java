package fileExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1 {
	
	public static void main(String[] args) {
		try {
			File file = new File("userInfo/userId");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
