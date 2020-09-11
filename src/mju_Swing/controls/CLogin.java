package mju_Swing.controls;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import mju_Swing.valueObject.VUserInfo;

public class CLogin {
	
	public VUserInfo validateUser(String id, String password) {
		try {
			File file = new File("userInfo/userId");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				String userId = sc.nextLine();
				if(userId.equals(id)) {
					
					File userFile = new File("userInfo/" + id);
					sc = new Scanner(userFile);
					while(sc.hasNextLine()) {
						String userPassword = sc.nextLine();
						if(userPassword.equals(password)) {
							String userName = sc.nextLine();
							String userDepartment = sc.nextLine();
							
							VUserInfo vUserInfo = new VUserInfo(userId, userPassword, userName, userDepartment);
							return vUserInfo;
						}
						
						return null;
						
					}
				}
			}
			
			sc.close();
			return null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
