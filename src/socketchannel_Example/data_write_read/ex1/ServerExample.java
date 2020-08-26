package socketchannel_Example.data_write_read.ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

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
				
				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");
				byteBuffer = ByteBuffer.allocate(100);
				int byteCount = socket.read(byteBuffer);
				byteBuffer.flip();
				String message = charset.decode(byteBuffer).toString();
				System.out.println(message);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	
}
