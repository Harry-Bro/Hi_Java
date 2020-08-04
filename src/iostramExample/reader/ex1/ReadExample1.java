package iostramExample.reader.ex1;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample1 {

	public static void main(String[] args) throws IOException {
		
		Reader reader = new FileReader("/Users/harrybro/Desktop/무제.txt");
		int readData;
		while((readData = reader.read()) != -1) {
			System.out.print((char)readData);
		}
		reader.close();
		
	}
	
}
