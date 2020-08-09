package threadExample.chatEx1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerEx {
	
	ExecutorService es;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<>(); 

	public static void main(String[] args) {
		
		
		ServerEx server1 = new ServerEx();
		Scanner sc = new Scanner(System.in);
		
		switch(sc.nextLine()) {
		case "start":
			server1.startServer();
			break;
		case "stop":
			server1.stopServer();
			break;
		default:
			System.out.println("wrong command");
		}
		
		
	}
	
	void startServer() {
		
		es = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 6012));
			
		} catch (Exception e) {
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		Runnable runnable = () -> {
			System.out.println("서버 시작");
			
			while(true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("연결 수락" + socket.getRemoteSocketAddress() + ":" + Thread.currentThread().getName());
					Client client = new Client(socket);
					connections.add(client);
					System.out.println("연결 개수: " + connections.size());
				} catch (IOException e) {
					if(!serverSocket.isClosed()) {
						stopServer();
					}
					break;
				}
			}
		};
		
		// ThreadPool에 runnable을 담음
		es.submit(runnable);
	}
		
	void stopServer() {

		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			
			if(!serverSocket.isClosed() && serverSocket != null) {
				serverSocket.close();
			}
			
			if(!es.isShutdown() && es != null) {
				es.shutdown();
			}
			
			System.out.println("Server Stop");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	class Client {
		Socket socket = null;
		
		Client(Socket socket) {
			this.socket = socket;
			receive();
		}
		
		void receive() {
			Runnable runnable = () -> {
				try {
				// Client에서 보낸 데이터를 계속 받기 위해서 무한 루프 작성
					while(true) {
						//Client에서 보낸 배열을 받을 바이트 배열 작성
						byte[] byteArr = new byte[100];
						InputStream is = socket.getInputStream();
						// byteArr에 읽은 바이트를 저장하고 바이트 수를 readByteCount에 저
						int readByteCount = is.read(byteArr);
						// Client가 종료를 하면 read가 -1을 리턴함
						if(readByteCount == -1) {
							throw new IOException();
						}
						System.out.println("요청 처리: " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
						// 읽은 바이트를 String으로 변환
						String data = new String(byteArr, 0, readByteCount, "UTF-8");
						System.out.println(data);
						// 모든 클라이언트에게 받은 데이터를 출력해주기 위함
						for(Client client:connections) {
							client.send(data);
						}
					}
				} catch(Exception e) {
					try {
						connections.remove(Client.this);
						System.out.println("Client Connetion Error" + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
						socket.close();
					} catch(IOException e1) {
						
					}
				}
				
			};
			es.submit(runnable);
		}
		
		void send(String data) {
			Runnable runnable = () -> {
				try {
					byte[] byteArr = data.getBytes("UTF-8");
					OutputStream os = socket.getOutputStream();
					os.write(byteArr);
					os.flush();
				} catch (Exception e) {
					try {
						// 보내고자 하는데 클라이언트가 통신이 안 되면 예외가 발생할 것임
						System.out.println("Client Connetion Error" + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
						connections.remove(Client.this);
						socket.close();
					} catch (IOException e1) {
					}

				}
			};
			es.submit(runnable);
		}
		

	}
}