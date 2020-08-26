package socketchannel_Example.chatting.ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client1 {

	public static void main(String[] args) {
		Client1 c1 = new Client1();
		c1.startClient();
		c1.send();
		c1.recieve();
	}
	
	SocketChannel socket = null;
	
	void startClient() {
		try {
			socket = SocketChannel.open();
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("서버와 연결 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void stopClient() {
		if(socket.isOpen()) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void send() {
		try {
			Charset charset = Charset.forName("UTF-8");
			String message = "Client에서 보낸 메시지";
			ByteBuffer byteBuffer = charset.encode(message);
			socket.write(byteBuffer);
			System.out.println("메시지 전송 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void recieve() {
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		try {
			int readByteBufferCount = socket.read(byteBuffer);
			if(readByteBufferCount == -1) {
				throw new IOException();
			}
			byteBuffer.flip();
			String message = charset.decode(byteBuffer).toString();
			System.out.println(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
