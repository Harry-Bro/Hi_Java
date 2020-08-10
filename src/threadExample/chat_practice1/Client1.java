package threadExample.chat_practice1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
	
	Socket socket;
	InputStream is;
	OutputStream os;
	Scanner scanner;
	
	public static void main(String[] args) {
		Client1 client = new Client1();
		client.startClient();
	}
	
	void startClient() {
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9209));
			System.out.println("서버와 연결 성공");
			receive();
			send();
		} catch (IOException e) {
			System.out.println("서버와 연결이 안됩니다.");
		}
		
	}
	
	void receive() {
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread receiveThread = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					try {
						byte[] byteArr = new byte[100];
						int byteArrCount;
						byteArrCount = is.read(byteArr);
						String message = new String(byteArr, 0, byteArrCount);
						System.out.println(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		receiveThread.start();
	}
	
	void send() {
		scanner = new Scanner(System.in);
		Thread sendThread = new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						os = socket.getOutputStream();
						String message = scanner.nextLine();
						byte[] data = message.getBytes();
						os.write(data);
						os.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}
			}
		};
		sendThread.start();
	}
	
}
