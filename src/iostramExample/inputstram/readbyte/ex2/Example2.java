package iostramExample.inputstram.readbyte.ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example2 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("/Users/harrybro/Desktop/무제.txt");
		
		byte[] b = new byte[3];
		int a;
		String data = "";
		while((a = is.read(b)) != -1) {
			data += new String(b, 0, a);
		}
		System.out.println(data);
		
	}
	
}
