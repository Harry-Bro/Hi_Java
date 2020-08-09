package threadExample.chatEx1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {
	
	Socket socket;

	public static void main(String[] args) {
		ClientEx client = new ClientEx();
		client.startClient();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String data = sc.nextLine();
			if(!data.equals("end")) {
				client.send(data);
			} else {
				client.stopClient();
				break;
			}
		}
	}
	
	void startClient() {
		// 연결 시작 코드
		// 서버와 연결이 되기 전까지 블락킹이 되기 때문에 thread 생성
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress("localhost", 6012));
					System.out.println("연결 성공: " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
				} catch(Exception e) {
					System.out.println("연결 실패: " + Thread.currentThread().getName());
					if(!socket.isClosed()) {
						return;
					}
				}
				receive();
			}
		};
		
		thread.start();
	}
	
	void stopClient() {
		// 연결 끊기 코드
		System.out.println("exit");
		if(socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	void send(String data) {
		// 데이터를 보내는 시간이 오래걸리면 UI가 멈춰있기 때문에
		// 별도의 Thread를 생성해서 보내는 것이 좋음
		Thread thread = new Thread() {
			@Override
			public void run() {
				
				try {
					// 매개값은 문자열을 바이트로 변환 후 송출
					byte[] byteArr = data.getBytes();
					OutputStream os = socket.getOutputStream();
					os.write(byteArr);
					os.flush();
					System.out.println("보내기 완료");
				} catch(Exception e) {
					System.out.println("서버 통신 안됨");
					stopClient();
					
				}
				
			}
		};
		
		thread.start();
	}
	
	void receive() {
		// 서버에서 데이터를 게속 받기 위해서 무한 루프를 작성
		while(true) {
			try {
				// 데이터를 받을 바이트 배열 생성
				byte[] byteArr = new byte[100];
				InputStream is = socket.getInputStream();
				int byteArrCount = is.read(byteArr);
				if(byteArrCount == -1) {
					throw new IOException();
				}
				// 받은 데이타 String으로 변환
				String data = new String(byteArr, 0, byteArrCount, "UTF-8");
				System.out.println("받은 데이터: " + data);
			} catch(Exception e) {
				stopClient();
				break;
			}
		}
	}
	
}
