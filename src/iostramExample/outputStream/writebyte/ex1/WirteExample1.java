package iostramExample.outputStream.writebyte.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WirteExample1 {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = new FileOutputStream("/Users/harrybro/Desktop/무제.txt");
		byte[] data = "ABCD\nabcd".getBytes();
		for(int i=0; i<data.length; i++) {
			os.write(data[i]);
		}
		os.flush();
		os.close();
	}
	
}
