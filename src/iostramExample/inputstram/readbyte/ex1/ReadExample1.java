package iostramExample.inputstram.readbyte.ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample1 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("/Users/harrybro/Desktop/무제.txt");
		int readByte;
		while((readByte = is.read()) != -1) {
			 System.out.println((char)readByte);
		}
		is.close();
	}
	
}
