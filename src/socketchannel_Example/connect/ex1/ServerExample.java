package socketchannel_Example.connect.ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerExample {

	public static void main(String[] args) {
		ServerSocketChannel server = null;
		try {
			server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(5001));
			
			while(true) {
				System.out.println("연결 기다림");
				SocketChannel socket = server.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteAddress();
				System.out.println("연결 수락함" + isa.getHostName());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	
}
