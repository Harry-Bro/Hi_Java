package iostramExample.inputstram.readbyte.ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example1 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("/Users/harrybro/Desktop/무제.txt");
		
		int i;
		while(true) {
			i = is.read();
			if(i == -1) break;
			System.out.println((char)i);
			
		}
		is.close();
	}
	
}
