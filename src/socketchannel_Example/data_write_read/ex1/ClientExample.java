package socketchannel_Example.data_write_read.ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientExample {

	public static void main(String[] args) {
		
		SocketChannel socket = null;
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			System.out.println("연결 요청");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("Success");
			
			ByteBuffer byteBuffer = null;
			Charset charset = Charset.forName("UTF-8");
			String data = "Hello world I love Java";
			byteBuffer = charset.encode(data);
			socket.write(byteBuffer);
			System.out.println("데이터 보내기 성공");
			
		} catch (IOException e) {
			//generated catch block
			e.printStackTrace();
		}
		
		if(socket.isOpen()) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
