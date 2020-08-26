package socketchannel_Example.connect.ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientExample {

	public static void main(String[] args) {
		
		SocketChannel socket = null;
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			System.out.println("연결 요청");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("Success");
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
