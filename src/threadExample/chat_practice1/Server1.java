package threadExample.chat_practice1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server1 {

	ExecutorService es;
	ServerSocket serverSocket;
	Vector<Client> connections = new Vector<>();
	
	
	public static void main(String[] args) {
		
		Server1 sv = new Server1();
		sv.startServer();
	}
	
	void startServer() {
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 9209));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		es = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		
		Runnable task = () -> {
		
			while(true) {
				try {
					Socket socket = new Socket();
					socket = serverSocket.accept();
					connections.add(new Client(socket));
					System.out.println("연결 성공");
				} catch (IOException e) {
//					e.printStackTrace();
				}
			}
			
		};
		
		es.submit(task);
			
	}
	
	class Client {
		
		private Socket socket;
		private InputStream is;
		private OutputStream os;
		
		public Client(Socket socket) {
			this.socket = socket;
			receive();
		}
		
		private void receive() {
			
			Runnable receiveTask = () -> {
				while(true) {
					try {
						is = socket.getInputStream();
						byte[] byteArr = new byte[100];
						int byteArrCount = is.read(byteArr);
						String data = new String(byteArr, 0, byteArrCount);
						send(data);
						System.out.println(data);
						
						for(Client connection:connections) {
							connection.send(data);
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			
			es.submit(receiveTask);
		}
		
		private void send(String data) {
			
			Runnable taskSend = () -> {
				byte[] message;
				try {
					message = data.getBytes("UTF-8");
					os = socket.getOutputStream();
					os.write(message);
					os.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
			es.submit(taskSend);
			
		}
		
	}
}
