package iostramExample.outputStream.writebyte.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = new FileOutputStream("/Users/harrybro/Desktop/무제.txt");
		byte[] data = "ABCD".getBytes();
		os.write(data);
		os.flush();
		os.close();
		
	}
	
}
