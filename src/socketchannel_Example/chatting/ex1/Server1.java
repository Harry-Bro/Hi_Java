package socketchannel_Example.chatting.ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server1 {

	public static void main(String[] args) {
		Server1 s1 = new Server1();
		s1.startServer();
	}
	
	ExecutorService es;
	ServerSocketChannel server = null;
	List<Client> connections = new Vector<>();
	
	void startServer() {
		es = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		try {
			server = ServerSocketChannel.open();
			server.bind(new InetSocketAddress("localhost", 5001));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Runnable runnable = () -> {
			try {
				while(true) {
					SocketChannel socket = server.accept();
					connections.add(new Client(socket));
					System.out.println("연결 수락");
				}
			} catch(IOException e) {
				
			}
		};
		
		es.submit(runnable);
		
	}
	
	void stopServer() {
		Iterator<Client> iterator = connections.iterator();
		while(iterator.hasNext()) {
			Client client = iterator.next();
			try {
				client.socket.close();
				iterator.remove();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!server.isOpen() && server != null) {
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!es.isShutdown() && es != null) {
			es.shutdown();
		}
		
		System.out.println("서버 종료");
	}
	
	class Client {
		SocketChannel socket;
		public Client(SocketChannel socket) {
			this.socket = socket;
			receive();
		}
		
		void receive() {
			Runnable runnable = () -> {
				while(true) {
					try {
						ByteBuffer byteBuffer = ByteBuffer.allocate(100);
						int readByteCount = socket.read(byteBuffer);
						
						if(readByteCount == -1) {
							throw new IOException();
						}
						
						byteBuffer.flip();
						Charset charset = Charset.forName("UTF-8");
						String message = charset.decode(byteBuffer).toString();
						System.out.printf("클라이언트에서 보낸 메시지: %s %n", message);
						
						for(Client client:connections) {
							client.send(message);
						}
					} catch(IOException e) {
						connections.remove(Client.this);
						System.out.println("클라이언트 연결 끊김");
						try {
							socket.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					}
				}
			};
			es.submit(runnable);
		}
		
		void send(String data) {
			Runnable runnable = () -> {
				Charset charset = Charset.forName("UTF-8");
				ByteBuffer byteBuffer = charset.encode(data);
				try {
					socket.write(byteBuffer);
				} catch (IOException e) {
					System.out.println("클라이언트 통신 안됨.");
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					connections.remove(Client.this);
				}
			};
			
			es.submit(runnable);
		}
	}
	
}

